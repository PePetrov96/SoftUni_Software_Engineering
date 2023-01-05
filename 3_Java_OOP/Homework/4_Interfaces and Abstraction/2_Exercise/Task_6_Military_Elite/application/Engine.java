package Task_6_Military_Elite.Application;

import Task_6_Military_Elite.inputOutput.InputReader;
import Task_6_Military_Elite.inputOutput.OutputWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Engine {
    public static void run() throws IOException {
        InputReader inputReader = new InputReader(new InputStreamReader(System.in), "End");

        CommandParser commandParser = new CommandParser(inputReader.readAllLines());

        Army army = commandParser.parseCommands();

        OutputWriter outputWriter = new OutputWriter(new OutputStreamWriter(System.out));

        outputWriter.writeAll(army);
    }
}