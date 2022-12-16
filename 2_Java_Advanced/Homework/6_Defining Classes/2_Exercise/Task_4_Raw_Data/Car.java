public class Car {
    String carModel;
    Engine engine;
    Cargo cargo;
    Tier tier;

    public boolean printFragile () {
        if (tier.lowTier1Pressure() && cargo.isFragile()) {
            return true;
        }
        if (tier.lowTier2Pressure() && cargo.isFragile()) {
            return true;
        }
        if (tier.lowTier3Pressure() && cargo.isFragile()) {
            return true;
        }
        return tier.lowTier4Pressure() && cargo.isFragile();
    }

    public boolean printFlammable() {
        return engine.isBigEngine() && !cargo.isFragile();
    }

    public Car(String carModel, Engine engine, Cargo cargo, Tier tier) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tier = tier;
    }

    @Override
    public String toString() {
        return String.format(this.carModel);
    }
}