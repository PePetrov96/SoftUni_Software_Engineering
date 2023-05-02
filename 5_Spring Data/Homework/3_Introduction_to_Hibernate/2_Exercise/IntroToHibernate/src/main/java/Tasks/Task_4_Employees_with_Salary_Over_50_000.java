package Tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Task_4_Employees_with_Salary_Over_50_000 {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) throws IOException {
        String sqlQuery =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.salary > 50000";

        List<Employee> employeesList = em.createQuery(sqlQuery, Employee.class)
                .getResultList();

        for (Employee employee : employeesList) {
            System.out.println(employee.getFirstName());
        }

        em.close();
        factory.close();
    }
}
