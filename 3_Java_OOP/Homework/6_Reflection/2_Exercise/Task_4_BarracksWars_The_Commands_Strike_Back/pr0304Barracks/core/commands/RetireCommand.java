package pr0304Barracks.core.commands;

import jdk.jshell.spi.ExecutionControl;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

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
