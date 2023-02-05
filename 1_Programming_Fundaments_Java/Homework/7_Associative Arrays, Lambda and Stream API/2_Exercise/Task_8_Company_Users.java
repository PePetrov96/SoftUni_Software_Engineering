import java.util.*;

public class Task_8_Company_Users {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> companyList = new LinkedHashMap<>();
        String[] input = scan.nextLine().split(" -> ");

        while (!input[0].equals("End")) {
            addEmployee(companyList, input);
            input = scan.nextLine().split(" -> ");
        }
        companyList.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(employee -> System.out.println("-- " + employee));
        });
    }
    private static void addEmployee (Map<String, List<String>> companyList, String[] input) {
        String company = input[0];
        String employeeID = input[1];
        if (!companyList.containsKey(company)) {
            companyList.put(company, new ArrayList<>());
        }
        if (!companyList.get(company).contains(employeeID)) {
            companyList.get(company).add(employeeID);
        }
    }
}