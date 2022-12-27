public class Person implements Comparable<Person>{
    String name;
    int age;
    String town;
    public Person(String input) {
        String[] tokens = input.split("\\s+");
        this.name = tokens[0];
        this.age = Integer.parseInt(tokens[1]);
        this.town = tokens[2];
    }

    @Override
    public int compareTo(Person person) {
        int n = this.name.compareTo(person.getName());
        if (n == 0) {
            n = Integer.compare(this.age, person.getAge());
            if (n == 0){
                n = this.town.compareTo(person.getTown());
            }
        }
        return n;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}