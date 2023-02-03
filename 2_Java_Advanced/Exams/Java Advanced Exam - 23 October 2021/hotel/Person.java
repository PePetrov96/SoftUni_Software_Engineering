package hotel;

public class Person {
    private String name;
    private int id;
    private int age;
    private String hometown = "n/a";

    public Person(String name, int id, int age, String hometown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s", this.name, this.id, this.age, this.hometown);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setHometown(String hometown) {
        this.hometown = hometown;
    }
}