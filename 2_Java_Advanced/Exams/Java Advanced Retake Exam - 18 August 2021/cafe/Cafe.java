package cafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Cafe {
    private final Collection<Employee> employees;
    private final String name;
    private final int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (getCount() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        return this.employees.remove(getEmployee(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder(String.format("Employees working at Cafe %s:", this.name))
                .append(System.lineSeparator());

        this.employees.forEach(employee -> result
                                                .append(employee.toString())
                                                .append(System.lineSeparator()));

        return result.toString();
    }
}