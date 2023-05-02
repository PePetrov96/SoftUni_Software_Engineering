package Tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Task_10_Increase_Salaries {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) throws IOException {
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

        em.close();
        factory.close();
    }
}