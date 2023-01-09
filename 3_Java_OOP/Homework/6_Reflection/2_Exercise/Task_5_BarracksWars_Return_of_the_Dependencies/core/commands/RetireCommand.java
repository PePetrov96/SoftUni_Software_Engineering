package Task_5_BarracksWars_Return_of_the_Dependencies.core.commands;

import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Inject;
import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import jdk.jshell.spi.ExecutionControl;


public class RetireCommand extends CommandImpl {

    @Inject
    private Repository repository;

    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(this.getData()[1]);
            return this.getData()[1] + " retired!";
        } catch (ExecutionControl.NotImplementedException e) {
            return e.getMessage();
        }
    }
}
