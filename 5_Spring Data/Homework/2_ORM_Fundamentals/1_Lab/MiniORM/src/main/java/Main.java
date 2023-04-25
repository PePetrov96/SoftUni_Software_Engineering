import entities.User;
import manager.EntityManager;
import orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Connection connection = MyConnector.getConnection(); //create a new Connection from the class

        EntityManager<User> userManager = new EntityManager<>(connection); //create a new Entity Manager

        //add entry in the DB
        User user1 = new User("Ivan", 23, LocalDate.now());
        User user2 = new User("Kiro", 22, LocalDate.now());
        userManager.persist(user1);
        userManager.persist(user2);

        // use findFirst
        User userA = userManager.findFirst(User.class);
        System.out.println(userA.getId() + " " + userA.getUsername()); //1 Ivan

        // use findFirst WHERE
        User userB = userManager.findFirst(User.class, "user_name = 'Kiro'");
        System.out.println(userB.getId() + " " + userB.getUsername()); //2 Kiro

        //use extraction with a specific where clause;
        List<User> allUsers = new ArrayList<>();
        for (User user : userManager.find(User.class, "YEAR(registration_date) >= '2000' AND age >= 18")) {
            allUsers.add(user);
        }
        System.out.println(allUsers.toString().replaceAll("[\\[\\]]", ""));
    }
}