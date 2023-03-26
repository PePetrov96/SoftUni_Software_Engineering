package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        setBoothNumber(boothNumber);
        setCapacity(capacity);
        setNumberOfPeople(numberOfPeople);
        setPricePerPerson(pricePerPerson);
        this.isReserved = false;
    }

    private void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return this.boothNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public boolean isReserved() {
        return this.isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setReserved(true);
        setNumberOfPeople(numberOfPeople);
        setPrice(numberOfPeople * pricePerPerson);
    }

    @Override
    public double getBill() {
        double cocktailPrices = cocktailOrders.stream()
                .mapToDouble(Cocktail::getPrice)
                .sum();

        double delicacyPrices = delicacyOrders.stream()
                .mapToDouble(Delicacy::getPrice)
                .sum();

        return (price + cocktailPrices + delicacyPrices);
    }

    @Override
    public void clear() {
        setReserved(false);
        setPrice(0);
        setNumberOfPeople(0);
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
    }
}