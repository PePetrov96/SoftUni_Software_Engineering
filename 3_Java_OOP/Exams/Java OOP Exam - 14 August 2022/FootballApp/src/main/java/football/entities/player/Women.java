package football.entities.player;

public class Women extends BasePlayer{
    private static final double INITIAL_KG = 60.00;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KG, strength);
    }

    @Override
    public void stimulation() {
        super.setStrength(super.getStrength() + 115);
    }
}