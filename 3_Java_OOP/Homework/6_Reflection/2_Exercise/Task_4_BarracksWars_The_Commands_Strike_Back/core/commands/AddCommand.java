package Task_4_BarracksWars_The_Commands_Strike_Back.core.commands;

import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Repository;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.UnitFactory;

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
