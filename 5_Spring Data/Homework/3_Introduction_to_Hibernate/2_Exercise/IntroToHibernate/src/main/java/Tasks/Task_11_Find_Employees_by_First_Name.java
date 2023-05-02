package Tasks;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Task_11_Find_Employees_by_First_Name {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
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

        em.close();
        factory.close();
    }
}