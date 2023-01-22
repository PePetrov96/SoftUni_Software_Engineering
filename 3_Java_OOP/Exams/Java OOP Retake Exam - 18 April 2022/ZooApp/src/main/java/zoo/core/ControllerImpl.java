package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.HashMap;

public class ControllerImpl implements Controller {
    FoodRepository foodRepository;
    HashMap<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new HashMap<>();
    }


    @Override
    public String addArea(String areaType, String areaName) {
        switch (areaType) {
            case "WaterArea": areas.put(areaName, new WaterArea(areaName));
                break;
            case "LandArea": areas.put(areaName, new LandArea(areaName));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        switch (foodType) {
            case "Meat": foodRepository.add(new Meat());
                break;
            case "Vegetable": foodRepository.add(new Vegetable());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);

        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
        }

        areas.get(areaName).addFood(food);
        foodRepository.remove(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        switch (animalType) {
            case "AquaticAnimal": animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal": animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }

        String currAnimal = animal.getClass().getSimpleName();
        String currArea = areas.get(areaName).getClass().getSimpleName();

        if ((currAnimal.equals("AquaticAnimal") && currArea.equals("LandArea")) ||
                (currAnimal.equals("TerrestrialAnimal") && currArea.equals("WaterArea"))) {

            return String.format(ConstantMessages.AREA_NOT_SUITABLE);
        } else {

            areas.get(areaName).addAnimal(animal);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        }
    }

    @Override
    public String feedAnimal(String areaName) {
        int count = Math.max(0, areas.get(areaName).getAnimals().size());

        areas.get(areaName).feed();

        return String.format(ConstantMessages.ANIMALS_FED, count);
    }

    @Override
    public String calculateKg(String areaName) {
        double totalKG = Math.max(0.0, areas.get(areaName)
                .getAnimals()
                .stream()
                .mapToDouble(Animal::getKg)
                .sum());

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, totalKG);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        areas.values().forEach(area -> out
                .append(area.getInfo())
                .append(System.lineSeparator()));

        return out.toString().trim();
    }
}
