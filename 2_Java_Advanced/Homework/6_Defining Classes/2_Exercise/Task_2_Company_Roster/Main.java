import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Department> departmentList = new HashMap<>();

        for (int cycles = 0; cycles < n; cycles++) {
            addDepartment(departmentList, reader.readLine().split("\\s+"));
        }

        printResult(getTopDepartment(departmentList));
    }
    private static void printResult (Department topDepartment) {
        System.out.println("Highest Average Salary: " + topDepartment.getName());
        topDepartment
                .getEmployees()
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }

    private static Department getTopDepartment (Map<String, Department> departmentList) {
        return departmentList.values()
                .stream()
                .max(Comparator.comparing(Department::getAverageSalary))
                .get();
    }
    private static void addDepartment (Map<String, Department> departmentList, String[] input) {
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];

        Employee employee = new Employee(name, salary, position, department);
        addAdditionalDetails(employee, input);

        if (!departmentList.containsKey(department)) {
            departmentList.put(department, new Department());
        }

        departmentList.get(department).addEmployee(employee);

    }
    private static void addAdditionalDetails(Employee employee, String[] input) {
        if (input.length == 6) {
            employee.setEmail(input[4]);
            employee.setAge(Integer.parseInt(input[5]));
        } else if (input.length == 5) {
            try {
                employee.setAge(Integer.parseInt(input[4]));
            } catch (NumberFormatException e) {
                employee.setEmail(input[4]);
            }
        }
    }
}