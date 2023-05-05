import entities.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("gringotts");
    private static final EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        em.getTransaction().begin();

        //add a wizard to the DB
        WizardDeposit wd = new WizardDeposit("Ivanov", 25);
        em.persist(wd);

        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}
