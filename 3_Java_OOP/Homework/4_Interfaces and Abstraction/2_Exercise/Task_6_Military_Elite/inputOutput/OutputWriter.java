package Task_6_Military_Elite.inputOutput;
import Task_6_Military_Elite.Application.Army;
import Task_6_Military_Elite.Interfaces.Soldier;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputWriter {
    private final BufferedWriter writer;

    public OutputWriter(OutputStreamWriter streamWriter) {
        this.writer = new BufferedWriter(streamWriter);
    }

    public void writeAll(Army army) throws IOException {
        for (Soldier soldier : army.getSoldiers()) {
            this.writer.write(soldier.toString()+System.lineSeparator());
        }
        this.writer.close();
    }
}