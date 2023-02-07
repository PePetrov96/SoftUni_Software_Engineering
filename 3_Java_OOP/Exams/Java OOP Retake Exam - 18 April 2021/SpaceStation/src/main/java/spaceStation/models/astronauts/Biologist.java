package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double INITIAL_OXYGEN = 70.0;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath(){
        super.setOxygen(Math.max(0, super.getOxygen() - 5));
    }
}