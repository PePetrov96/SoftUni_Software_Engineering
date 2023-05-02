import entities.*;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //2. Change casing
        task1();

        //3. Contains Employee
        task2();

        //4. Employees with Salary Over 50 000
        task3();

        //5. Employees from Department
        task4();

        //6. Adding a New Address and Updating Employee
        task5();

        //7. Addresses with Employee Count
        task6();

        //8. Get Employee with Project
        task7();

        //9. Find Latest 10 Projects
        task8();

        //10. Increase Salaries
        task9();

        //11. Find Employees by First Name
        task10();

        //12. Employees Maximum Salaries
        task11();

        //13. Remove Towns
        task12();

        em.close();
        factory.close();

    }
    private static void task1 (){
        em.getTransaction().begin();

        String sqlQuery =
                "SELECT t " +
                "FROM Town AS t";

        List<Town> towns = em.createQuery(sqlQuery, Town.class)
                .getResultList();

        for (Town town : towns) {
            if (town.getName().length() > 5) {
                em.detach(town);
            } else {
                town.setName(town.getName().toUpperCase());
                em.merge(town);
            }
        }

        em.getTransaction().commit();
    }

    private static void task2() throws IOException {
        String fullName = reader.readLine();

        String sqlQuery =
                "SELECT COUNT(e) " +
                "FROM Employee AS e " +
                "WHERE CONCAT_WS(' ', e.firstName, e.lastName) = :fullName";

        TypedQuery<Long> query = em.createQuery(sqlQuery, Long.class)
                .setParameter("fullName", fullName);

        Long count = query.getSingleResult();

        if (count > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void task3() {
        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.salary > 50000";

        List<Employee> employeesList = em.createQuery(sqlQuery, Employee.class)
                .getResultList();

        for (Employee employee : employeesList) {
            System.out.println(employee.getFirstName());
        }
    }

    private static void task4() {
        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "JOIN e.department AS d " +
                "WHERE d.name = 'Research and Development' " +
                "ORDER BY e.salary, " +
                "e.id";

        TypedQuery<Employee> query = em.createQuery(sqlQuery, Employee.class);
        List<Employee> employeesList = query.getResultList();

        for (Employee employee : employeesList) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

    }

    private static void task5() throws IOException {
        //add the address if it doesn't exist (this can be done directly from the DB, but is a good practice)
        addAddress();

        String query1 =
                "SELECT a " +
                "FROM Address AS a " +
                "WHERE a.text = 'Vitoshka 15'";

        Address address = em.createQuery(query1, Address.class)
                .getSingleResult();

        String lastName = reader.readLine();

        String query2 =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.lastName = :lastName";

        Employee employee = em.createQuery(query2, Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();

        employee.setAddress(address);

        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    private static void addAddress() {
        // First, let's find the town with the given name
        String query1 =
                "SELECT t " +
                "FROM Town AS t " +
                "WHERE t.name = 'SOFIA'";

        Town town = em.createQuery(query1, Town.class)
                .getSingleResult();

        // Then, let's check if the address exists
        String query2 =
                "SELECT a " +
                "FROM Address AS a " +
                "WHERE a.text = 'Vitoshka 15'";

        List<Address> addresses = em.createQuery(query2, Address.class)
                .getResultList();

        if (addresses.isEmpty()) {
            // If the address doesn't exist, create a new Address object and set its properties
            Address address = new Address();
            address.setText("Vitoshka 15");
            address.setTown(town);

            // Persist the new address object to the database
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        }
    }

    private static void task6() {
        String sqlQuery =
                "SELECT CONCAT(a.text, ', ', t.name, ' - ', COUNT(e.id), ' employees') " +
                "FROM Address AS a " +
                "JOIN a.employees AS e " +
                "JOIN a.town AS t " +
                "GROUP BY a.text " +
                "ORDER BY COUNT(e.id) DESC";

        List<String> addressList = em.createQuery(sqlQuery, String.class)
                .setMaxResults(10)
                .getResultList();

        for (String address : addressList) {
            System.out.println(address);
        }
    }

    private static void task7() throws IOException {
        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.id = :employeeID";

        Integer employeeID = Integer.parseInt(reader.readLine());

        Employee employee = em.createQuery(sqlQuery, Employee.class)
                .setParameter("employeeID",employeeID)
                .getSingleResult();

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        List<Project> projects = employee.getProjects().stream()
                .sorted(Comparator.comparing(Project::getName))
                .toList();

        for (Project project : projects) {
            System.out.println(project.getName());
        }
    }

    private static void task8() {
        String sqlQuery1 =
                "SELECT startDate " +
                "FROM Project p " +
                "ORDER BY startDate DESC";

        List<LocalDateTime> dates = em.createQuery(sqlQuery1, LocalDateTime.class)
                .setMaxResults(10)
                .getResultList();

        LocalDateTime date = dates.get(dates.size()-1);

        String sqlQuery =
                "SELECT p " +
                "FROM Project p " +
                "WHERE p.startDate >= :date " +
                "ORDER BY p.name";

        List<Project> projects = em.createQuery(sqlQuery, Project.class)
                .setParameter("date", date)
                .setMaxResults(10)
                .getResultList();

        for (Project project : projects) {
            System.out.printf("""
                    Project name: %s
                            Project Description: %s
                            Project Start Date: %s
                            Project End Date: %s%n""",
                    project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
        }
    }

    private static void task9() {
        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.department.name IN (:departments)";

        List<Employee> employees = em.createQuery(sqlQuery, Employee.class)
                .setParameter("departments", Arrays.asList("Engineering", "Tool Design", "Marketing", "Information Services"))
                .getResultList();

        em.getTransaction().begin();

        for (Employee employee : employees) {
            BigDecimal currentSalary = employee.getSalary();
            BigDecimal increasedSalary = currentSalary.multiply(new BigDecimal("1.12"));

            employee.setSalary(increasedSalary);
            em.merge(employee);

            System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), increasedSalary);
        }

        em.getTransaction().commit();
    }

    private static void task10() throws IOException {
        String pattern = reader.readLine() + "%";

        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.firstName LIKE :pattern";

        List<Employee> employees = em.createQuery(sqlQuery, Employee.class)
                .setParameter("pattern", pattern)
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - %s - ($%.2f)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary());
        }
    }

    private static void task11() {
        String sqlQuery =
                "SELECT CONCAT(department.name, ' ', MAX(salary)) " +
                "FROM Employee AS e " +
                "GROUP BY department " +
                "HAVING MAX(salary) NOT BETWEEN 30000 AND 70000";

        TypedQuery<String> query = em.createQuery(sqlQuery, String.class);

        List<String> departments = query.getResultList();

        for (String dept : departments) {
            System.out.println(dept);
        }

    }

    private static void task12() throws IOException {
        String townName = reader.readLine();

        // Retrieve the townID based on the given town name
        String townIdQuery =
                "SELECT id " +
                "FROM Town " +
                "WHERE name = :townName";

        Integer townId = em.createQuery(townIdQuery, Integer.class)
                .setParameter("townName", townName)
                .getSingleResult();

        // Delete all addresses that have the retrieved townID
        String deleteAddressQuery =
                "DELETE FROM Address " +
                "WHERE town.id  = :townId";

        em.getTransaction().begin();

        // Disable foreign key constraint check
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0")
                .executeUpdate();

        int deletedCount = em.createQuery(deleteAddressQuery)
                .setParameter("townId", townId)
                .executeUpdate();

        // Enable foreign key constraint check
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1")
                .executeUpdate();

        em.getTransaction().commit();

        // Print the number of deleted addresses along with the town name
        if (deletedCount == 1) {
            System.out.printf("%d address in %s deleted", deletedCount, townName);
        } else {
            System.out.printf("%d addresses in %s deleted", deletedCount, townName);
        }
    }
}