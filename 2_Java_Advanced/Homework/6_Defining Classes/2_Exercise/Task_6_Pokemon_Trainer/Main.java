import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Trainer> trainerList = new LinkedHashMap<>();

        String input;
        while (!"Tournament".equals(input = reader.readLine())) {
            catchPokemon(trainerList, input.split("\\s+"));
        }

        while (!"End".equals(input = reader.readLine())) {
            String type = input;

            trainerList
                    .values()
                    .forEach(trainer -> trainer.makeFight(type));
        }

        printResult(trainerList);

    }
    private static void printResult (LinkedHashMap<String, Trainer> trainerList) {
        trainerList
                .values()
                .stream()
                .sorted(Comparator.comparing(Trainer::getBadges).reversed())
                .forEach(System.out::println);
    }
    private static void catchPokemon(LinkedHashMap<String, Trainer> trainerList, String[] input) {
        String trainerName = input[0];
        String pokemonName = input[1];
        String pokemonType = input[2];
        int pokemonHealth = Integer.parseInt(input[3]);

        Pokemon newPokemon = new Pokemon(pokemonName, pokemonType, pokemonHealth);

        if (!trainerList.containsKey(trainerName)) {
            trainerList.put(trainerName, new Trainer(trainerName));
        }

        trainerList.get(trainerName).pokemons.add(newPokemon);
    }
}