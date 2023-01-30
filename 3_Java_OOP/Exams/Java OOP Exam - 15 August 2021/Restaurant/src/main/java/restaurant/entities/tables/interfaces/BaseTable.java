package restaurant.entities.tables.interfaces;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table{
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private final int number;
    private int size;
    private int numberOfPeople;
    private final double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;


    public BaseTable(int number, int size, double pricePerPerson) {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.isReservedTable = false;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.allPeople = numberOfPeople() * pricePerPerson();
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double beverageCost = this.beverages.stream()
                .mapToDouble(Beverages::getPrice)
                .sum();

        double foodCost = this.healthyFood.stream()
                .mapToDouble(HealthyFood::getPrice)
                .sum();

        return beverageCost + foodCost + allPeople();
    }

    @Override
    public void clear() {
        this.beverages = new ArrayList<>();
        this.healthyFood = new ArrayList<>();
        this.numberOfPeople = 0;
        this.isReservedTable = false;
    }

    @Override
    public String tableInformation() {
        return (String.format("Table - %d", this.number) +
                System.lineSeparator() +
                String.format("Size - %d", this.size) +
                System.lineSeparator() +
                String.format("Type - %s", this.getClass().getSimpleName()) +
                System.lineSeparator() +
                String.format("All price - %f", this.pricePerPerson) +
                System.lineSeparator()).trim();
    }
}