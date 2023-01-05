package Task_6_Military_Elite.Application;

import Task_6_Military_Elite.Common.MissionImpl;
import Task_6_Military_Elite.Common.RepairImpl;
import Task_6_Military_Elite.Enumerations.Corp;
import Task_6_Military_Elite.Enumerations.State;
import Task_6_Military_Elite.Interfaces.Mission;
import Task_6_Military_Elite.Interfaces.Private;
import Task_6_Military_Elite.Interfaces.Soldier;
import Task_6_Military_Elite.Models.*;

import java.util.List;

public class Command {
    private Soldier soldier = null;
    private final Army ARMY = new Army();

    public Army getARMY() {
        return ARMY;
    }

    public void execute(String command, List<String> tokens) {

        switch (command) {
            case "Private": addPrivate(tokens); break;
            case "LieutenantGeneral": addLieutenantGeneral(tokens); break;
            case "Engineer": addEngineer(tokens); break;
            case "Commando": addCommando(tokens); break;
            case "Spy": addSpy(tokens); break;
        }

        if (soldier != null) {
            this.getARMY().addSoldier(soldier);
        }
    }

    private void addPrivate(List<String> tokens) {
        int id = Integer.parseInt(tokens.get(0));
        String firstName = tokens.get(1);
        String lastName = tokens.get(2);

        soldier = new PrivateImpl(id,
                firstName,
                lastName,
                Double.parseDouble(tokens.get(3)));
    }

    private void addLieutenantGeneral(List<String> tokens) {
        int id = Integer.parseInt(tokens.get(0));
        String firstName = tokens.get(1);
        String lastName = tokens.get(2);

        soldier = new LieutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(tokens.get(3)));
        int[] ids = tokens.stream().skip(4).mapToInt(Integer::parseInt)
                .toArray();
        for (int currentId : ids) {
            for (int i = 0; i < this.getARMY().getSoldiers().size(); i++) {
                if (this.getARMY().getSoldiers().get(i) instanceof Private) {
                    if (this.getARMY().getSoldiers().get(i).getId() == currentId) {
                        ((LieutenantGeneralImpl) soldier).addPrivate((Private) this.getARMY().getSoldiers().get(i));
                    }
                }
            }
        }
    }
    private void addEngineer(List<String> tokens) {
        int id = Integer.parseInt(tokens.get(0));
        String firstName = tokens.get(1);
        String lastName = tokens.get(2);
        String corps = tokens.get(4);

        if (Corp.Airforces.toString().equals(corps) || Corp.Marines.toString().equals(corps)) {
            soldier = new EngineerImpl(id, firstName, lastName, Double.parseDouble(tokens.get(3)),
                    Corp.valueOf(corps));

            String[] repairData = tokens.stream().skip(5).toArray(String[]::new);

            for (int i = 0; i < repairData.length; i += 2) {
                String name = repairData[i];
                int workHours = Integer.parseInt(repairData[i + 1]);
                RepairImpl repair = new RepairImpl(name, workHours);
                ((EngineerImpl) soldier).addRepair(repair);
            }
        }
    }
    private void addCommando(List<String> tokens) {
        int id = Integer.parseInt(tokens.get(0));
        String firstName = tokens.get(1);
        String lastName = tokens.get(2);
        String corps = tokens.get(4);

        if (Corp.Airforces.toString().equals(corps) || Corp.Marines.toString().equals(corps)) {
            soldier = new CommandoImpl(id, firstName, lastName, Double.parseDouble(tokens.get(3)),
                    Corp.valueOf(corps));

            String[] missionData = tokens.stream().skip(5).toArray(String[]::new);

            for (int i = 0; i < missionData.length; i += 2) {
                String name = missionData[i];
                String state = missionData[i + 1];

                if (State.finished.toString().equals(state) || State.inProgress.toString().equals(state)) {
                    Mission mission = new MissionImpl(name, State.valueOf(state));
                    ((CommandoImpl) soldier).addMission(mission);
                }
            }
        }
    }
    private void addSpy(List<String> tokens) {
        int id = Integer.parseInt(tokens.get(0));
        String firstName = tokens.get(1);
        String lastName = tokens.get(2);

        soldier = new SpyImpl(id, firstName, lastName, tokens.get(3));
    }
}