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
    private List<Reportable> database;

    public Pokedex(){
       this.pokemons = new ArrayList<>();
       this.database = new ArrayList<>();
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

    public String getPokemonEvolutionsInformation(String aName){
        Pokemon pokemon = this.getPokemonByName(aName);
        return pokemon.getEvolutionsInformation();
    }

    public void addPokemon(Pokemon aPokemon) throws IOException {

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(aPokemon.getName())){
                return;
            }
        }
        this.pokemons.add(aPokemon);
        System.out.println("pokemon added, sending notification to DB");
        this.notifyDB();
    }

    public void removePokemon(String name) throws IOException {

        pokemons.removeIf(obj -> obj.getName().equals(name));
        this.notifyDB();
    }


    public void addAllPokemon(List<Pokemon> Pokemons) throws IOException {
        this.pokemons.addAll(Pokemons);
        this.notifyDB();
    }

    public void addDatabase(Reportable database){
        this.database.add(database);
    }


    public void editPokemonName(String oldName, String newName) throws IOException {

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(oldName)){
                pokemon.editName(newName);
            }
        }
        this.notifyDB();
    }

    public void addPokemonAbility(String name, String ability) throws IOException {

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.addAbility(new Ability(ability));
            }
        }
        this.notifyDB();
    }

    public void editPokemonType(String name, Type type) throws IOException {

        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.editType(type);
            }
        }
        this.notifyDB();
    }

    public void addPokemonEvolution(String name, Pokemon evolution) throws IOException {
        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.addEvolution(evolution);
            }
        }
        this.notifyDB();
    }

    public void editPokemonLevel(String name, int level) throws IOException {
        for(Pokemon pokemon : pokemons){
            if (pokemon.getName().equals(name)){
                pokemon.editLevel(level);
            }
        }
        this.notifyDB();
    }

    public Object getPokemons() {
        return pokemons;
    }

    private void notifyDB() throws IOException {
        if(database.isEmpty()) return;
        for(Reportable element : database){
            element.notifyDB();
        }
    }
}
