package Tasks;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Task_6_Adding_a_New_Address_and_Updating_Employee {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
    private static final EntityManager em = factory.createEntityManager();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        //add the address if it doesn't exist (this can be done directly from the DB, but is a good practice)
        addAddress();

        String query1 =
                "SELECT a " +
                "FROM Address AS a " +
                "WHERE a.text = 'Vitoshka 15'";

        Address address = em.createQuery(query1, Address.class)
                .getSingleResult();

        String lastName = reader.readLine();

        String query2 =
                "SELECT e " +
                "FROM Employee AS e " +
                "WHERE e.lastName = :lastName";

        Employee employee = em.createQuery(query2, Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();

        employee.setAddress(address);

        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();

        em.close();
        factory.close();
    }
    private static void addAddress() {
        // First, let's find the town with the given name
        String query1 =
                "SELECT t " +
                "FROM Town AS t " +
                "WHERE t.name = 'SOFIA'";

        Town town = em.createQuery(query1, Town.class)
                .getSingleResult();

        // Then, let's check if the address exists
        String query2 =
                "SELECT a " +
                "FROM Address AS a " +
                "WHERE a.text = 'Vitoshka 15'";

        List<Address> addresses = em.createQuery(query2, Address.class)
                .getResultList();

        if (addresses.isEmpty()) {
            // If the address doesn't exist, create a new Address object and set its properties
            Address address = new Address();
            address.setText("Vitoshka 15");
            address.setTown(town);

            // Persist the new address object to the database
            em.getTransaction().begin();
            em.persist(address);
            em.getTransaction().commit();
        }
    }
}