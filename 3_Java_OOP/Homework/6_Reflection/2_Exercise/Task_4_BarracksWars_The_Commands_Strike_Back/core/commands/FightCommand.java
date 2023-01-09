package Task_4_BarracksWars_The_Commands_Strike_Back.core.commands;

import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Repository;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.UnitFactory;

public class FightCommand extends CommandImpl {
    protected FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
