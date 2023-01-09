package Task_4_BarracksWars_The_Commands_Strike_Back.core.commands;

import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Executable;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.Repository;
import Task_4_BarracksWars_The_Commands_Strike_Back.contracts.UnitFactory;

public abstract class CommandImpl implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected CommandImpl(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
