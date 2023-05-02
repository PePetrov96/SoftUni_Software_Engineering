package Tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Task_5_Employees_from_Department {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) throws IOException {
        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "JOIN e.department AS d " +
                "WHERE d.name = 'Research and Development' " +
                "ORDER BY e.salary, " +
                "e.id";

        List<Employee> employeesList = em.createQuery(sqlQuery, Employee.class)
                .getResultList();

        for (Employee employee : employeesList) {
            System.out.printf("%s %s from %s - $%.2f%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

        em.close();
        factory.close();
    }
}