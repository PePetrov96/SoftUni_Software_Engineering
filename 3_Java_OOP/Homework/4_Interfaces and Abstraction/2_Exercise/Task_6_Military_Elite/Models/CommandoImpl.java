package Task_6_Military_Elite.Models;

import Task_6_Military_Elite.Enumerations.Corp;
import Task_6_Military_Elite.Interfaces.Commando;
import Task_6_Military_Elite.Interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private final List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append(this.getCorps())
                .append(System.lineSeparator()).append("Missions:");
        for (Mission mission: this.missions) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(mission.toString());
        }
        return sb.toString();
    }
}