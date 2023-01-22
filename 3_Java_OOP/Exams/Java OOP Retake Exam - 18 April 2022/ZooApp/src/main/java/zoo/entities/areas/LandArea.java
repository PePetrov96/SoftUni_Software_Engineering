package zoo.entities.areas;

public class LandArea extends BaseArea{
    private static final int INITIAL_CAPACITY = 25;

    public LandArea(String name) {
        super(name, INITIAL_CAPACITY);
    }
}