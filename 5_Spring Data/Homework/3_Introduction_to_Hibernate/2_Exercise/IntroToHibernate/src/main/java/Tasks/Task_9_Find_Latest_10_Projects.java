package Tasks;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Task_9_Find_Latest_10_Projects {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    public static void main(String[] args) throws IOException {
        String sqlQuery1 =
                "SELECT startDate " +
                "FROM Project p " +
                "ORDER BY startDate DESC";

        List<LocalDateTime> dates = em.createQuery(sqlQuery1, LocalDateTime.class)
                .setMaxResults(10)
                .getResultList();

        LocalDateTime date = dates.get(dates.size()-1);

        String sqlQuery =
                "SELECT p " +
                "FROM Project p " +
                "WHERE p.startDate >= :date " +
                "ORDER BY p.name";

        List<Project> projects = em.createQuery(sqlQuery, Project.class)
                .setParameter("date", date)
                .setMaxResults(10)
                .getResultList();

        for (Project project : projects) {
            System.out.printf("""
                    Project name: %s
                            Project Description: %s
                            Project Start Date: %s
                            Project End Date: %s%n""",
                    project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
        }

        em.close();
        factory.close();
    }
}