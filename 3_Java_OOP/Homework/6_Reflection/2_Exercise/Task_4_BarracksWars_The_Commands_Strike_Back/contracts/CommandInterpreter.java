package Task_4_BarracksWars_The_Commands_Strike_Back.contracts;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
