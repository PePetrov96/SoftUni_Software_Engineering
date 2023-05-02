package Tasks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_13_Remove_Towns {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
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

        em.close();
        factory.close();
    }
}