package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.Food;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood>{

    private final Collection<HealthyFood> entities;

    public HealthFoodRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(HealthyFood entity) {
        this.entities.add(entity);
    }

    @Override
    public HealthyFood foodByName(String name) {
        return this.entities.stream()
                .filter(food -> food.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
