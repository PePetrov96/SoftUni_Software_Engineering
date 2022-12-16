package PII;
public class Child {
    private String childName;
    private String childBirthday;

    @Override
    public String toString() {
        return String.format("%s %s", this.childName, this.childBirthday);
    }

    public void updateChild (String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }
}