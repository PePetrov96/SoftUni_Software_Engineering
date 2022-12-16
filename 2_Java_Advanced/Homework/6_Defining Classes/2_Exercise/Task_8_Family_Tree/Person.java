import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final String birthday;
    private final List<String> parents;
    private final List<String> children;

    public Person(String name, String birthday) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getParents() {
        return parents;
    }

    public List<String> getChildren() {
        return children;
    }
}