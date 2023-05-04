package Tasks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_3_Contains_Employee {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String fullName = reader.readLine();

        String sqlQuery =
                "SELECT COUNT(e) " +
                "FROM Employee AS e " +
                "WHERE CONCAT_WS(' ', e.firstName, e.lastName) = :fullName";

        Long count = em.createQuery(sqlQuery, Long.class)
                .setParameter("fullName", fullName)
                .getSingleResult();

        if (count > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        em.close();
        factory.close();
    }
}
