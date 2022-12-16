public class Employee {
    private final String name;
    private final double salary;
    private final String position;
    private final String department;
    private String email;
    private int age;

    public double getSalary() {
        return salary;
    }
    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        email = "n/a";
        age = -1;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
