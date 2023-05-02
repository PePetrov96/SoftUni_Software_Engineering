package Tasks;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Task_2_Change_casing {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) {
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

        em.close();
        factory.close();
    }
}
