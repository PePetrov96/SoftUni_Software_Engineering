package Task_5_BarracksWars_Return_of_the_Dependencies.core.commands;

import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Inject;
import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;

public class AddCommand extends CommandImpl {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        this.repository.addUnit(this.unitFactory.createUnit(this.getData()[1]));

        return this.getData()[1] + " added!";
    }
}
