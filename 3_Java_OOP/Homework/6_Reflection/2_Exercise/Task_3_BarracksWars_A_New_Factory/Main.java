package Task_3_BarracksWars_A_New_Factory;

import Task_3_BarracksWars_A_New_Factory.interfaces.Repository;
import Task_3_BarracksWars_A_New_Factory.interfaces.Runnable;
import Task_3_BarracksWars_A_New_Factory.interfaces.UnitFactory;
import Task_3_BarracksWars_A_New_Factory.core.Engine;
import Task_3_BarracksWars_A_New_Factory.core.factories.UnitFactoryImpl;
import Task_3_BarracksWars_A_New_Factory.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
