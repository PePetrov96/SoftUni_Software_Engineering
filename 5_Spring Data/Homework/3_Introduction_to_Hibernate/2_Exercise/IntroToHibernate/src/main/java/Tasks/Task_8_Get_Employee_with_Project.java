package Tasks;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class Task_8_Get_Employee_with_Project {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
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

        em.close();
        factory.close();
    }
}