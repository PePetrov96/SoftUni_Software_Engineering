package sanctuary;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.setName(name);
        this.setAge(age);
        this.setRetiredFrom(retiredFrom);
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s", this.name, this.age, this.retiredFrom);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }
}