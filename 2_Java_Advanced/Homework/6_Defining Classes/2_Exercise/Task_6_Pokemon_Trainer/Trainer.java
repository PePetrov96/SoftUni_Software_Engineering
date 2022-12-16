import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    String trainerName;
    int numberOfBadges;
    List<Pokemon> pokemons;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }
    public boolean hasThisType (String type) {
        for (Pokemon pokemon : getPokemons()) {
            if (pokemon.element.equals(type)) {
                return true;
            }
        }
        return false;
    }
    public void takeDamage() {
        for (Pokemon pokemon : pokemons) {
            pokemon.health -= 10;
        }

        pokemons = pokemons.stream()
                .filter(pokemon -> pokemon.health > 0)
                .collect(Collectors.toList());
    }

    public void makeFight(String type) {
        if (hasThisType(type)) {
            ++numberOfBadges;
        } else {
            takeDamage();
        }
    }
    public int getBadges() {
        return numberOfBadges;
    }

    public int getPokemonsSize() {
        return pokemons.size();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.trainerName, getBadges(), getPokemonsSize());
    }
}