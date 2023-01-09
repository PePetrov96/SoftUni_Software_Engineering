package Task_5_BarracksWars_Return_of_the_Dependencies.core.commands;

import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Inject;
import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Repository;


public class ReportCommand extends CommandImpl {

    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
