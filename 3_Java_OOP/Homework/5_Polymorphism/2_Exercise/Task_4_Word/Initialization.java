package Task_4_Word;

public class Initialization{
    public static CommandInterface buildCommandInterface (StringBuilder text) {
        CommandInterface commandInterface = new AdvancedCommand(text);
        commandInterface.init();

        return commandInterface;
    }
}
