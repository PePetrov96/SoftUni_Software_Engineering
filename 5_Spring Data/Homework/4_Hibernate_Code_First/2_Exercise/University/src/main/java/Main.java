import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("university_system");
    private static final EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        em.getTransaction().begin();

        //create students, teachers and courses and add them in the DB
        Student student1 = new Student("Ivan", "Ivanov", "+359 888 88 8888", 4.38, 5);
        Student student2 = new Student("Gosho", "Goshov", "+359 888 88 8888", 5.23, 3);
        Student student3 = new Student("Petko", "Petkov", "+359 888 88 8888", 3.31, 1);

        Teacher teacher1 = new Teacher("Kiro", "Kirov", "+359 888 88 8888", "Kiro.Kirov@abv.bg", 35.58);
        Teacher teacher2 = new Teacher("Stefo", "Stefov", "+359 888 88 8888", "Stefo.Stefov@abv.bg", 15.58);
        Teacher teacher3 = new Teacher("Mitko", "Mitkov", "+359 888 88 8888", "Mitko.Mitkov@abv.bg", 155.58);

        Course course1 = new Course("Biology", "Studies about the human biology", new Date(2022-1-1), new Date(2023-1-1), 35);
        Course course2 = new Course("Astronomy", "Studies about space", new Date(2023-4-2), new Date(2024-5-4), 55);

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);

        em.persist(teacher1);
        em.persist(teacher2);
        em.persist(teacher3);

        //add students and teachers to the courses (they will persist automatically)
        course1.setTeacher(teacher1);
        course1.addStudent(student1);
        course1.addStudent(student2);

        course2.setTeacher(teacher3);
        course2.addStudent(student1);
        course2.addStudent(student3);

        em.getTransaction().commit();

        factory.close();
        em.close();
    }
}