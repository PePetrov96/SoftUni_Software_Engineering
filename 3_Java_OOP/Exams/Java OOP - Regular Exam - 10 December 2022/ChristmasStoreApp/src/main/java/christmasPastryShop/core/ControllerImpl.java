package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    private double totalIncome = 0;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        DelicacyType delicacyType = DelicacyType.valueOf(type);

        switch (delicacyType) {
            case Gingerbread:
                    this.delicacyRepository.add(new Gingerbread(name, price));
                break;
            case Stolen:
                    this.delicacyRepository.add(new Stolen(name, price));
                break;
        }

        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);

        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        CocktailType cocktailType = CocktailType.valueOf(type);

        switch (cocktailType) {
            case MulledWine:
                    this.cocktailRepository.add(new MulledWine(name, size, brand));
                break;
            case Hibernation:
                    this.cocktailRepository.add(new Hibernation(name, size, brand));
                break;
        }

        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        if (booth != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
        }

        BoothType boothType = BoothType.valueOf(type);

        switch (boothType) {
            case OpenBooth:
                    this.boothRepository.add(new OpenBooth(boothNumber, capacity));
                break;
            case PrivateBooth:
                    this.boothRepository.add(new PrivateBooth(boothNumber, capacity));
                break;
        }

        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = this.boothRepository.getAll().stream()
                .filter(booth1 -> !booth1.isReserved() && booth1.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (booth == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        this.boothRepository.getByNumber(booth.getBoothNumber())
                .reserve(numberOfPeople);

        return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = this.boothRepository.getByNumber(boothNumber);

        double bill = booth.getBill();
        this.totalIncome += bill;

        this.boothRepository.getByNumber(boothNumber).clear();

        return String.format(OutputMessages.BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalIncome);
    }
}
