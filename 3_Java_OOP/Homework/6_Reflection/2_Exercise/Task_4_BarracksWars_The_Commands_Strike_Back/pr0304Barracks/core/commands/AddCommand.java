package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

public class AddCommand extends CommandImpl {

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        this.getRepository().addUnit(this.getUnitFactory().createUnit(this.getData()[1]));

        return this.getData()[1] + " added!";
    }
}
