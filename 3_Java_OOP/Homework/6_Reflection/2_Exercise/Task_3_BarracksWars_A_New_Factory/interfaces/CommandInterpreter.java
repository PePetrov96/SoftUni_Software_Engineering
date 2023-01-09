package Task_3_BarracksWars_A_New_Factory.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
