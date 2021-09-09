package pokedex.lite;

import org.junit.jupiter.api.Test;
import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Pokemon.Evolution;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.Electric;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    @Test
    public void pokemonReturnsCorrectBasicInformation(){

        Pokemon pikachu = new Pokemon("Pikachu", new Electric(), 10);
        assertEquals("Pikachu, Electric, 10", pikachu.getBasicInformation());
    }

    @Test
    public void pokemonReturnsCorrectAdvancedInformation(){

        Pokemon pikachu = new Pokemon("Pikachu", new Electric(), 10);
        pikachu.addAbility(new Ability("Static"));
        pikachu.addAbility(new Ability("Thunder"));
        pikachu.addEvolution(new Evolution("Raichu", new Electric(), 15));
        assertEquals("Evolutions: Raichu, Abilities: Static, Thunder", pikachu.getAdvancedInformation());
    }

    @Test
    public void pokemonReturnsCorrectEvolutionsInformation(){

        Pokemon pikachu = new Pokemon("Pichu", new Electric(), 1);
        pikachu.addAbility(new Ability("Static"));
        pikachu.addEvolution(new Evolution("Pikachu", new Electric(), 10));
        pikachu.addEvolution(new Evolution("Raichu", new Electric(), 15));
        assertEquals("Pikachu, Electric, 10\nRaichu, Electric, 15", pikachu.getEvolutionsInformation());
    }

}
