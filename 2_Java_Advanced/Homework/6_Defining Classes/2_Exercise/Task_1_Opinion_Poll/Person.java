public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isOldEnough () {
        return getAge() > 30;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", getName(), getAge());
    }
}
