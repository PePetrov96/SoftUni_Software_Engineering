import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("sales_database");
    private static final EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        em.getTransaction().begin();

        //add Entities and make a Sale
        Product product = new Product("iPhoneX", 1, new BigDecimal("2000"));
        Customer customer = new Customer("Peter Petrov", "peter.petrov@abv.bg", "5555 5555 5555 5555");
        StoreLocation storeLocation = new StoreLocation("Sofia");

        Sale sale = new Sale(product, customer, storeLocation, LocalDateTime.now());


        em.persist(product);
        em.persist(customer);
        em.persist(storeLocation);

        em.persist(sale);


        em.getTransaction().commit();

        factory.close();
        em.close();
    }
}