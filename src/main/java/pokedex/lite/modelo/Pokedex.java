package pokedex.lite.modelo;

import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pokedex {

    private List<Pokemon> pokemons;

    public Pokedex(){
        pokemons = new ArrayList<Pokemon>();
    }

    public String listPokemons(){
        String pokemonsString = pokemons.stream().map(Pokemon::getBasicInformation)
                .collect(Collectors.joining("\n"));
        return pokemonsString;
    }

    private Pokemon getPokemonByName(String name){
        for (Pokemon pokemon : pokemons){
            if (pokemon.hasName(name))
                return pokemon;
        }
        return null;
    }

    public String getPokemonName(Pokemon aPokemon) { return aPokemon.getName(); }

    public Type getPokemonType(Pokemon aPokemon){
        return aPokemon.getType();
    }

    public Integer getPokemonLevel(Pokemon aPokemon){
        return aPokemon.getLevel();
    }

    public String getPokemonBasicInformation(String aName){
        Pokemon pokemon = this.getPokemonByName(aName);
        return pokemon.getBasicInformation();
    }

    public void getPokemonAdvanceInformation(String aName){
        Pokemon pokemon = this.getPokemonByName(aName);

    }

    public void addPokemon(){

    }

    public void editPokemonName(){

    }

    public void editPokemonType(){

    }

    public void addPokemonEvolution(){

    }

    public void updatePokemonLevel(){

    }
}
