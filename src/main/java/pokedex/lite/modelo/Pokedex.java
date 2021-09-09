package pokedex.lite.modelo;

import pokedex.lite.Reportable;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pokedex {

    private List<Pokemon> pokemons;
    private Reportable database;

    public Pokedex(){
       this.pokemons = new ArrayList<>();
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

    public String getPokemonAdvanceInformation(String aName){
        Pokemon pokemon = this.getPokemonByName(aName);
        return pokemon.getAdvancedInformation();
    }

    public void addPokemon(Pokemon aPokemon) throws IOException {

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(aPokemon.getName())){
                return;
            }
        }
        this.pokemons.add(aPokemon);
        this.database.notifyDB();
    }

    public void removePokemon(String name) throws IOException {

        pokemons.removeIf(obj -> obj.getName().equals(name));
        this.database.notifyDB();
    }


    public void addAllPokemon(List<Pokemon> Pokemons) throws IOException {
        this.pokemons.addAll(Pokemons);
        this.database.notifyDB();
    }

    public void addDatabase(Reportable database){
        this.database = database;
    }


    public void editPokemonName(String oldName, String newName){

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(oldName)){
                pokemon.editName(newName);
            }
        }
    }

    public void editPokemonType(String name, Type type){

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.editType(type);
            }
        }
    }

    public void addPokemonEvolution(String name, Pokemon evolution){
        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.addEvolution(evolution);
            }
        }
    }

    public void updatePokemonLevel(String name, int level){
        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.editLevel(level);
            }
        }
    }

    public Object getPokemons() {
        return pokemons;
    }
}
