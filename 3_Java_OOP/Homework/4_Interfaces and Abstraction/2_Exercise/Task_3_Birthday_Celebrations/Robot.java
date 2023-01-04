package Task_3_Birthday_Celebrations;

public class Robot implements Identifiable {
    private final String id;

    private final String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}