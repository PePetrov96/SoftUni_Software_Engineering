package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument {
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    private void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        setPower(Math.max(0, getPower() - 10));
    }

    @Override
    public boolean isBroken() {
        return getPower() == 0;
    }
}
