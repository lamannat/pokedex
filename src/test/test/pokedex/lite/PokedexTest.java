package pokedex.lite;

import org.junit.jupiter.api.Test;
import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Pokedex;
import pokedex.lite.modelo.Pokemon.Evolution;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.*;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokedexTest {

    private Pokemon testPokemon = new Pokemon("Test", new Normal(), 1);
    @Test
    public void pokedexStoresPokemonInformation() throws IOException {

        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(testPokemon);

        assertEquals("Test, Normal, 1", pokedex.listPokemons());
    }

    @Test
    public void pokedexReturnsInformationForAGivenName() throws IOException {

        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(testPokemon);

        assertEquals("Test, Normal, 1", pokedex.getPokemonBasicInformation("Test"));
    }

    @Test
    public void pokedexReturnsAdvancedForAGivenName() throws IOException {

        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(testPokemon);

        testPokemon.addAbility(new Ability("testAbility"));
        testPokemon.addEvolution(new Evolution("testEvolution", new Normal(), 1));

        assertEquals("Evolutions: testEvolution, Abilities: testAbility", pokedex.getPokemonAdvanceInformation("Test"));
    }

    @Test
    public void pokedexReturnsEvolutionsInformationForAGivenName() throws IOException {

        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(testPokemon);

        testPokemon.addEvolution(new Evolution("testEvolution01", new Normal(), 1));
        testPokemon.addEvolution(new Evolution("testEvolution02", new Normal(), 2));

        assertEquals("testEvolution01, Normal, 1\ntestEvolution02, Normal, 2", pokedex.getPokemonEvolutionsInformation("Test"));
    }

    @Test
    public void aListOfPokemonsCanBeAddedToPokedex() throws IOException {
        Pokedex pokedex = new Pokedex();

        Pokemon p1 = new Pokemon("pokemon01", new Fire(), 1);
        Pokemon p2 = new Pokemon("pokemon02", new Water(), 2);

        ArrayList<Pokemon> pokemonsList = new ArrayList<>();
        pokemonsList.add(p1);
        pokemonsList.add(p2);

        pokedex.addAllPokemon(pokemonsList);

        assertEquals("pokemon01, Fire, 1\npokemon02, Water, 2", pokedex.listPokemons());
    }

    @Test
    public void pokemonInformationCanBeChanged() throws IOException {

        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(testPokemon);

        pokedex.editPokemonType("Test", new Water());
        pokedex.editPokemonLevel("Test", 7);
        pokedex.editPokemonName("Test", "NewName");

        assertEquals("NewName, Water, 7", pokedex.listPokemons());

    }
}
