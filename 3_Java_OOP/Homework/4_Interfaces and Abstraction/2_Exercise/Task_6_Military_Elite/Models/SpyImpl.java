package Task_6_Military_Elite.Models;

import Task_6_Military_Elite.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Code Number: " + this.codeNumber;
    }
}