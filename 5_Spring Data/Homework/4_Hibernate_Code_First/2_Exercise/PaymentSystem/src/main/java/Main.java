import entities.BankAccount;
import entities.BillingDetail;
import entities.CreditCard;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("payment_database");
    private static final EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        em.getTransaction().begin();

        //create 1 User and 2 Billing Details, and add both of them to the User
        User user1 = new User("Ivan", "Ivanov", "Ivan.Ivanov@gmail.com", "123456");

        BillingDetail bankAccount = new BankAccount("SECURE_NUMBER_1", "UBB Bank", "Some SWIFT Code");
        BillingDetail creditCard = new CreditCard("9999 9999 9999 9999", "Debit Card", "09", "25");

        user1.addBillingDetail(bankAccount);
        user1.addBillingDetail(creditCard);


        em.persist(user1);

        em.getTransaction().commit();

        factory.close();
        em.close();
    }
}