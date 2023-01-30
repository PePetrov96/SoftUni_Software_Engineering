package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {
    private final HealthFoodRepository<HealthyFood> healthFoodRepository;
    private final BeverageRepository<Beverages> beveragesRepository;
    private final TableRepository<Table> tableRepository;
    private double totalProfit;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {

        this.healthFoodRepository = healthFoodRepository;
        this.beveragesRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
        }

        switch (type) {
            case "Salad": this.healthFoodRepository.add(new Salad(name, price));
                break;
            case "VeganBiscuits": this.healthFoodRepository.add(new VeganBiscuits(name, price));
                break;
        }

        return String.format(OutputMessages.FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name){
        if (beveragesRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
        }

        switch (type) {
            case "Fresh": this.beveragesRepository.add(new Fresh(name, counter, brand));
                break;
            case "Smoothie": this.beveragesRepository.add(new Smoothie(name, counter, brand));
                break;
        }

        return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;

        switch (type) {
            case "Indoors": table = new Indoors(tableNumber, capacity);
                break;
            case "InGarden": table = new InGarden(tableNumber, capacity);
                break;
        }

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
        }

        this.tableRepository.add(table);

        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table table = this.tableRepository.getAllEntities()
                .stream()
                .filter(table1 -> table1.getSize() >= numberOfPeople &&
                        !table1.isReservedTable())
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            table.reserve(numberOfPeople);
            return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
        }
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = tableRepository.byNumber(tableNumber);
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        } else if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, healthyFoodName);
        } else {
            table.orderHealthy(food);
            return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
        }
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = tableRepository.byNumber(tableNumber);
        Beverages beverage = beveragesRepository.beverageByName(name, brand);

        if (table == null) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        } else if (beverage == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, name, brand);
        } else {
            table.orderBeverages(beverage);
            return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
        }
    }

    @Override
    public String closedBill(int tableNumber) {
        double bill = this.tableRepository.byNumber(tableNumber).bill();
        totalProfit += bill;

        this.tableRepository.byNumber(tableNumber).clear();

        return String.format(OutputMessages.BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(OutputMessages.TOTAL_MONEY, totalProfit);
    }
}