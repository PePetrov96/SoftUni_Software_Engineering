package goldDigger.models.discoverer;

import java.lang.reflect.Field;

public class Anthropologist extends BaseDiscoverer{
    private static final double INITIAL_ENERGY = 40;
    public Anthropologist(String name) {
        super(name, INITIAL_ENERGY);
    }
    @Override
    public void dig() {
        Field energyField;

        try {
            energyField = BaseDiscoverer.class.getDeclaredField("energy");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        energyField.setAccessible(true);
        double currentEnergy;

        try {
            currentEnergy = energyField.getDouble(this);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        try {
            energyField.setDouble(this, Math.max(0, currentEnergy - 15));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}