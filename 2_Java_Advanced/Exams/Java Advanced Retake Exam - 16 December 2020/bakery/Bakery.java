package bakery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Bakery {
    String name;
    int capacity;
    Collection<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (getCount() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name){
        return this.employees.remove(getEmployee(name));
    }

    public Employee getOldestEmployee(){
        return this.employees.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name){
        return this.employees.stream()
                .filter(employee -> employee.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report(){
        StringBuilder out = new StringBuilder(String.format("Employees working at Bakery %s:", this.name))
                .append(System.lineSeparator());

        for (Employee employee : employees) {
            out.append(employee.toString())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}