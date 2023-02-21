package Task_6_Military_Elite.Models;

import Task_6_Military_Elite.Interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {

    private final double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f", this.salary);
    }
}