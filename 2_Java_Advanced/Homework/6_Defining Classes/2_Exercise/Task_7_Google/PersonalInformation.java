import PII.Child;
import PII.Parent;
import PII.Company;
import PII.Car;
import PII.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PersonalInformation {
    String name;
    Car car;
    Company company;
    List<Parent> parents;
    List<Child> children;
    List<Pokemon> pokemons;

    public PersonalInformation(String name) {
        this.name = name;
        this.car = new Car();
        this.company = new Company();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void print() {
        System.out.println(this.name);
        System.out.println("Company:");
        System.out.printf(this.company.getCompanyName() == null ? "" : (this.company + "%n"));
        System.out.println("Car:");
        System.out.printf(this.car.getCarModel() == null ? "" : (this.car + "%n"));
        System.out.println("Pokemon:");
        if (pokemons.size() != 0) {pokemons.forEach(System.out::println);}
        System.out.println("Parents:");
        if (parents.size() != 0) {parents.forEach(System.out::println);}
        System.out.println("Children:");
        if (children.size() != 0) {children.forEach(System.out::println);}
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}