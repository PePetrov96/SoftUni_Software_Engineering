package Task_4_Food_Shortage;

public class Rebel implements Person, Buyer {
    private final String name;
    private final int age;
    private final String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public int getFood() {
        return food;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }
}