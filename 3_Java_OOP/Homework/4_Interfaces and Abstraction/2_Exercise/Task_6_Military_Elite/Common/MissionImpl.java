package Task_6_Military_Elite.Common;

import Task_6_Military_Elite.Enumerations.State;
import Task_6_Military_Elite.Interfaces.Mission;

public class MissionImpl implements Mission {
    private final String codeName;
    private final State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}