package Task_5_BarracksWars_Return_of_the_Dependencies.core.commands;

public class FightCommand extends CommandImpl {
    protected FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
