package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {

    private final Collection<Beverages> entities;

    public BeverageRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Beverages entity) {
        this.entities.add(entity);
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.entities.stream()
                .filter(beverages -> beverages.getName().equals(drinkName) &&
                        beverages.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }
}