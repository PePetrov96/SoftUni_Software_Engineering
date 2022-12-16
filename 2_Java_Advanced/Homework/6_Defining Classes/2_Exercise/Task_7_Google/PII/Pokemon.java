package PII;

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    @Override
    public String toString() {
        return String.format("%s %s", this.pokemonName, this.pokemonType);
    }

    public void updatePokemon (String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }
}