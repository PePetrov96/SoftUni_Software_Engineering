import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());
        if (result == 0) {
            char firstName = o1.getName().toLowerCase().charAt(0);
            char secondName = o2.getName().toLowerCase().charAt(0);
            result = Integer.compare(firstName, secondName);
        }
        return result;
    }
}
