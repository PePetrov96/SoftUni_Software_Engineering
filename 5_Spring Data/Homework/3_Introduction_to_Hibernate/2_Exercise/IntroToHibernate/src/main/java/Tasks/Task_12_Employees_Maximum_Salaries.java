package Tasks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class Task_12_Employees_Maximum_Salaries {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) throws IOException {
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

        em.close();
        factory.close();
    }
}