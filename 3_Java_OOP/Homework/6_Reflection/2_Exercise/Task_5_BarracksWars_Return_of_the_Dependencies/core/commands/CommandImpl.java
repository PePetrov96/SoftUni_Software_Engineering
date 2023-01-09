package Task_5_BarracksWars_Return_of_the_Dependencies.core.commands;

import Task_5_BarracksWars_Return_of_the_Dependencies.contracts.Executable;

public abstract class CommandImpl implements Executable {
    private String[] data;

    protected CommandImpl(String[] data) {
        this.data = data;

    }

    protected String[] getData() {
        return data;
    }

}
