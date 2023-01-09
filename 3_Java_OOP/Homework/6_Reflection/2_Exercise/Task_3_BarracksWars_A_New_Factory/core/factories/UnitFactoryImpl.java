package Task_3_BarracksWars_A_New_Factory.core.factories;

import Task_3_BarracksWars_A_New_Factory.interfaces.Unit;
import Task_3_BarracksWars_A_New_Factory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;

		try {
			Class<? extends Unit> unitClass = (Class<? extends Unit>) Class.forName(UnitFactoryImpl.UNITS_PACKAGE_NAME + unitType);
			Constructor<? extends Unit> constructor = unitClass.getConstructor();
			constructor.setAccessible(true);

			unit = constructor.newInstance();

		} catch (ClassNotFoundException |
				 NoSuchMethodException |
				 InstantiationException |
				 IllegalAccessException |
				 InvocationTargetException e) {
			e.printStackTrace();
		}

		return unit;
	}
}
