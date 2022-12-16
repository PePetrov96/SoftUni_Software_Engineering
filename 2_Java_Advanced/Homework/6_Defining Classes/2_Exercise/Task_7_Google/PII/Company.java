package PII;

public class Company {
    private String companyName;
    private String department;
    private double salary;

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.companyName, this.department, this.salary);
    }

    public void updateCompany (String companyName, String department, String salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = Double.parseDouble(salary);
    }

    public String getCompanyName() {
        return companyName;
    }
}