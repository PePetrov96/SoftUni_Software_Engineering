import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_1_Company_Roster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scan.nextLine().split("\\s+");
            collectEmployee(input, employeeList);
        }

        getOutput(employeeList);
    }
    private static void collectEmployee (String[] input, List<Employee> employeeList) {
        Employee employee = new Employee();
        employee.setName(input[0]); employee.setSalary(Double.parseDouble(input[1])); employee.setPosition(input[2]); employee.setDepartment(input[3]);
        if (input.length == 5) {
            try {
                employee.setAge(Integer.parseInt(input[4]));
            } catch (NumberFormatException e) {
                employee.setEmail(input[4]);
            }
        } else if (input.length == 6) {
            employee.setEmail(input[4]);
            employee.setAge(Integer.parseInt(input[5]));
        }
        employeeList.add(employee);
    }
    private static void getOutput (List<Employee> employeeList) {
        List<String> departments = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        List<Department> departmentList = new ArrayList<>();

        for (String department:departments) {
            departmentList.add(new Department(department, employeeList.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }
        departmentList.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = departmentList.get(0);
        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        department.getEmployee().stream().forEach(System.out::println);
    }
    public static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee () {
            this.email = "n/a";
            this.age = -1;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return String.format("%s %.2f %s %d", name, salary, email, age);
        }
    }
    public static class Department {
        String name;
        List<Employee> employee;
        double avgSalary;

        public Department(String name, List<Employee> employee) {
            this.name = name;
            this.employee = employee;
            this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployee() {
            return employee;
        }

        public double getAvgSalary() {
            return avgSalary;
        }
    }
}