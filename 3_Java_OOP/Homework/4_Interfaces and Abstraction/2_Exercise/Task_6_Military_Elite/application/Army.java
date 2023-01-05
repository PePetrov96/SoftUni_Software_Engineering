package Task_6_Military_Elite.Application;

import Task_6_Military_Elite.Interfaces.Soldier;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }
    public  void addSoldier(Soldier soldier){
        this.soldiers.add(soldier);
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }
}