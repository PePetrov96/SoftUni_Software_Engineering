package Task_4_BarracksWars_The_Commands_Strike_Back.core.commands;

import jdk.jshell.spi.ExecutionControl;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Repository;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.UnitFactory;

public class RetireCommand extends CommandImpl {
    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            this.getRepository().removeUnit(this.getData()[1]);
            return this.getData()[1]+" retired!";
        } catch (ExecutionControl.NotImplementedException e) {
           return e.getMessage();
        }
    }
}
