package restaurant.repositories.interfaces;

import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table>{

    private final Collection<Table> entities;

    public TableRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Table entity) {
        this.entities.add(entity);
    }

    @Override
    public Table byNumber(int number) {
        return this.entities.stream()
                .filter(table -> table.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}