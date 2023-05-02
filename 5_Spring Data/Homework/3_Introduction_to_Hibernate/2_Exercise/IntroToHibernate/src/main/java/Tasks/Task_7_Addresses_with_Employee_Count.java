package Tasks;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;

public class Task_7_Addresses_with_Employee_Count {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) throws IOException {
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

        em.close();
        factory.close();
    }
}