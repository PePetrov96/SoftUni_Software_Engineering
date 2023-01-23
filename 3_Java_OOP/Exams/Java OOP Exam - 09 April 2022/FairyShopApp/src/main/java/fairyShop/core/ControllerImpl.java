package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private final HelperRepository helperRepository;
    private final PresentRepository presentRepository;
    private int presentsCrafted;
    private int instrumentsBroken;

    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        switch (type) {
            case "Happy":
                helperRepository.add(new Happy(helperName));
                break;
            case "Sleepy":
                helperRepository.add(new Sleepy(helperName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        if (helperRepository.findByName(helperName) == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        Instrument instrument = new InstrumentImpl(power);

        helperRepository.findByName(helperName).addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, instrument.getPower(), helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        presentRepository.add(new PresentImpl(presentName, energyRequired));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Collection<Helper> helpersToUse = helperRepository.getModels().stream()
                .filter(helper -> helper.getEnergy() > 50)
                .collect(Collectors.toList());

        Present present = presentRepository.findByName(presentName);

        if (helpersToUse.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        instrumentsBroken = 0;
        String status = "not done";

        Shop shop = new ShopImpl();

        for (int i = 0; i < helpersToUse.size() && !present.isDone(); i++) {
            Helper currHelper = helpersToUse.iterator().next();

            shop.craft(present, currHelper);
        }

        if (present.isDone()) {
            status = "done";
            presentsCrafted++;
        }

        for (Helper helper : helpersToUse) {
            for (Instrument instrument : helper.getInstruments()) {
                if (instrument.isBroken()) {
                    instrumentsBroken++;
                }
            }
        }

        return String.format(
                String.format(ConstantMessages.PRESENT_DONE, presentName, status) +
                        String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, instrumentsBroken));
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder(String.format("%d presents are done!", presentsCrafted))
                .append(System.lineSeparator())
                .append("Helpers info:")
                .append(System.lineSeparator());

        helperRepository.getModels().stream().forEach(helper -> {
            int remaining = 0;
            for (Instrument instrument : helper.getInstruments()) {
                if (!instrument.isBroken()) {
                    remaining++;
                }
            }

            out.append(String.format("Name: %s", helper.getName()))
                    .append(System.lineSeparator())
                    .append(String.format("Energy: %s", helper.getEnergy()))
                    .append(System.lineSeparator())
                    .append(String.format("Instruments: %d not broken left", remaining))
                    .append(System.lineSeparator());
        });

        return out.toString().trim();
    }
}
