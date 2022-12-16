public class Tier {
    double tire1Pressure;
    int tire1Age;
    double tire2Pressure;
    int tire2Age;
    double tire3Pressure;
    int tire3Age;
    double tire4Pressure;
    int tire4Age;

    public Tier(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public boolean lowTier1Pressure() {
        return tire1Pressure < 1.0;
    }
    public boolean lowTier2Pressure() {
        return tire2Pressure < 1.0;
    }
    public boolean lowTier3Pressure() {
        return tire3Pressure < 1.0;
    }
    public boolean lowTier4Pressure() {
        return tire4Pressure < 1.0;
    }
}