package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.LinkedHashMap;

public class ControllerImpl implements Controller{
    private ToyRepository toys;
    private LinkedHashMap<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
    }

    @Override
    public String addHouse(String type, String name) {
        switch (type) {
            case "ShortHouse": houses.put(name, new ShortHouse(name));
                break;
            case "LongHouse": houses.put(name, new LongHouse(name));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        switch (type) {
            case "Ball": toys.buyToy(new Ball());
                break;
            case "Mouse": toys.buyToy(new Mouse());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }

        houses.get(houseName).buyToy(toy);
        toys.removeToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        switch (catType) {
            case "ShorthairCat": cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat": cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        String houseType = houses.get(houseName).getClass().getSimpleName();

        if ((houseType.equals("LongHouse") && catType.equals("ShorthairCat")) ||
                houseType.equals("ShortHouse") && catType.equals("LonghairCat")) {
            return String.format(ConstantMessages.UNSUITABLE_HOUSE);
        }

        houses.get(houseName).addCat(cat);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        this.houses.get(houseName).feeding();
        return String.format(ConstantMessages.FEEDING_CAT, this.houses.get(houseName).getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        double catValue = this.houses.get(houseName).getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toyValue = this.houses.get(houseName).getToys().stream().mapToDouble(Toy::getPrice).sum();

        double totalValue = catValue + toyValue;

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalValue);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        houses.values().forEach(house -> out
                .append(house.getStatistics())
                .append(System.lineSeparator()));

        return out.toString().trim();
    }
}