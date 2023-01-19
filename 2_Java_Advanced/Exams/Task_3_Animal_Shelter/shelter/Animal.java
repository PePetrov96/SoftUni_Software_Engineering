package shelter;

public class Animal {
    private String name;
    private int age;
    private String caretaker;

    public Animal(String name, int age, String caretaker) {
        this.setName(name);
        this.setAge(age);
        this.setCaretaker(caretaker);
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.caretaker);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCaretaker() {
        return caretaker;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }
}