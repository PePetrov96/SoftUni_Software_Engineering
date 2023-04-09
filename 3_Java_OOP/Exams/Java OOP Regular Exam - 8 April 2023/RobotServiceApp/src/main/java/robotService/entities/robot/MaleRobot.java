package robotService.entities.robot;

import java.lang.reflect.Field;

public class MaleRobot extends BaseRobot{ //Can only live in MainService
    private static final int INITIAL_KILOGRAMS = 9;
    public MaleRobot(String name, String kind, double price) {
        super(name, kind, INITIAL_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        Field kilogramsField;

        try {
            kilogramsField = BaseRobot.class.getDeclaredField("kilograms");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        kilogramsField.setAccessible(true);
        int currentKilograms;

        try {
            currentKilograms = kilogramsField.getInt(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            kilogramsField.setInt(this, currentKilograms + 3);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}