package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person{
    private double averageGrade;
    private int attendance;
    private Set<Course> courses = new HashSet<>();


    public Student() {
        super("STUDENT");
    }

    public Student(String firstName, String lastName, String phoneNumber, double averageGrade, int attendance) {
        this();

        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAverageGrade(averageGrade);
        setAttendance(attendance);
    }

    @Column(name = "average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    @Column(name = "attendance")
    public int getAttendance() {
        return attendance;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    public Set<Course> getCourses() {
        return courses;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course course) {
        this.courses.add(course);
    }
    public void removeCourse(Course course) {
        this.courses.remove(course);
    }
}