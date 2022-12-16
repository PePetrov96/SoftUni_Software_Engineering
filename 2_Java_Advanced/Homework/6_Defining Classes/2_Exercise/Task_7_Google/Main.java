import PII.Child;
import PII.Parent;
import PII.Pokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, PersonalInformation> peopleList = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            updateEntries(peopleList, input.split("\\s+"));
        }

        String printName = reader.readLine();

        peopleList.values()
                .stream()
                .filter(person -> person.name.equals(printName))
                .forEach(PersonalInformation::print);
    }
    private static void updateEntries (HashMap<String, PersonalInformation> peopleList, String[] input) {
        String name = input[0];
        String type = input[1];
        String firstToken = input[2];
        String secondToken = input[3];

        if (!peopleList.containsKey(name)) {
            PersonalInformation person = new PersonalInformation(name);
            peopleList.put(name, person);
        }

        switch (type) {
            case "company":
                peopleList.get(name).company.updateCompany(firstToken, secondToken, input[4]);
                break;
            case "pokemon":
                Pokemon newPokemon = new Pokemon();
                newPokemon.updatePokemon(firstToken, secondToken);
                peopleList.get(name).pokemons.add(newPokemon);
                break;
            case "parents":
                Parent newParent = new Parent();
                newParent.updateParent(firstToken, secondToken);
                peopleList.get(name).parents.add(newParent);
                break;
            case "children":
                Child newChild = new Child();
                newChild.updateChild(firstToken, secondToken);
                peopleList.get(name).children.add(newChild);
                break;
            case "car":
                peopleList.get(name).car.updateCar(firstToken, secondToken);
                break;
        }

    }
}