import java.util.Objects;

public class Person implements Comparable<Person>{
    String name;
    int age;
    public Person(String input) {
        String[] tokens = input.split("\\s+");
        this.name = tokens[0];
        this.age = Integer.parseInt(tokens[1]);
    }

    @Override
    public String toString(){
        return String.format("%s %d", this.name, this.age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        int n = this.name.compareTo(o.name);
        if (n == 0) {
            n = Integer.compare(this.age, o.age);
        }
        return n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name) && Objects.equals(age, other.age);
    }
}