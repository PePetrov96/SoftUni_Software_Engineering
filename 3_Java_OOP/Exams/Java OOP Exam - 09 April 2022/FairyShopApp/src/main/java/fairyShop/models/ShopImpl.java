package fairyShop.models;

public class ShopImpl implements Shop{
    @Override
    public void craft(Present present, Helper helper) {
        if (!helper.canWork()) {
            return;
        }

        boolean hasInstrument = false;
        for (Instrument instrument : helper.getInstruments()) {
            if (!instrument.isBroken()) {
                hasInstrument = true;
                break;
            }
        }

        if (hasInstrument) {
            while (!present.isDone() && helper.canWork()) {
                Instrument instrument = helper.getInstruments()
                        .stream()
                        .filter(instrument1 -> !instrument1.isBroken())
                        .findFirst()
                        .orElse(null);

                if (instrument == null) {
                    return;
                }

                instrument.use();
                present.getCrafted();
                helper.work();
            }
        }

    }
}