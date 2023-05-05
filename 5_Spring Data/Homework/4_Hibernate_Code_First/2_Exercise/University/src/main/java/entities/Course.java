package entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "courses")
public class Course {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int credits;
    private Teacher teacher;
    private Set<Student> students = new HashSet<>();

    public Course() {}

    public Course(String name, String description, Date startDate, Date endDate, int credits) {
        setName(name);
        setDescription(description);
        setStartDate(startDate);
        setEndDate(endDate);
        setCredits(credits);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "start_date", columnDefinition = "DATE")
    public Date getStartDate() {
        return startDate;
    }

    @Column(name = "end_date", columnDefinition = "DATE")
    public Date getEndDate() {
        return endDate;
    }

    @Column(name = "credits")
    public int getCredits() {
        return credits;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    public Teacher getTeacher() {
        return teacher;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Student> getStudents() {
        return students;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    private void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    private void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.addCourse(this);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
        student.removeCourse(this);
    }
}