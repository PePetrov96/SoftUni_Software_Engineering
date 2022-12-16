import java.util.ArrayList;
import java.util.List;

public class Department {
    private final List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }
    public double getAverageSalary() {
        return employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }
    public void addEmployee (Employee employee) {
        this.employees.add(employee);
    }
    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return employees.get(0).getDepartment();
    }
}