public class Person{
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
}