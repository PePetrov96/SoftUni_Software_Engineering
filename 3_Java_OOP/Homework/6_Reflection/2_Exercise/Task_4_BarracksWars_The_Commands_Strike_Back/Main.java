package Task_4_BarracksWars_The_Commands_Strike_Back;

import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Repository;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Runnable;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.UnitFactory;
import Task_4_BarracksWars_The_Commands_Strike_Back.core.Engine;
import Task_4_BarracksWars_The_Commands_Strike_Back.core.factories.UnitFactoryImpl;
import Task_4_BarracksWars_The_Commands_Strike_Back.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
