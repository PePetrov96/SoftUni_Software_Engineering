package PII;
public class Parent {
    private String parentName;
    private String parentBirthday;

    @Override
    public String toString() {
        return String.format("%s %s", this.parentName, this.parentBirthday);
    }

    public void updateParent (String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }
}