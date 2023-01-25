package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;

public abstract class BaseCat implements Cat{
    private String name;
    private String breed;
    private int kilograms;

    private double price;

    public BaseCat(String name, String breed, int kilograms, double price) {
        this.setName(name);
        this.setBreed(breed);
        this.kilograms = kilograms;
        this.setPrice(price);
    }

    private void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }

    private void setPrice(double price) {
        if (price <=0 ) {
            throw new IllegalArgumentException(ExceptionMessages.CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getKilograms() {
        return this.kilograms;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public abstract void eating();
}