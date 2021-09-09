package pokedex.lite;

import org.junit.jupiter.api.Test;
import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.Electric;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    @Test
    public void pokemonReturnsCorrectBasicInformation(){

        Pokemon pikachu = new Pokemon("Pikachu", new Electric(), 10, 0);
        assertEquals("Pikachu, Electric, 10", pikachu.getBasicInformation());
    }

    @Test
    public void pokemonReturnsCorrectAdvancedInformation(){

        Pokemon pikachu = new Pokemon("Pikachu", new Electric(), 10, 0);
        pikachu.addAbility(new Ability("Static"));
        pikachu.addAbility(new Ability("Thunder"));
        pikachu.addEvolution(new Pokemon("Raichu", new Electric(), 0, 15));
        assertEquals("Evolutions: Raichu, Abilities: Static, Thunder", pikachu.getAdvancedInformation());
    }

    @Test
    public void pokemonReturnsCorrectEvolutionsInformation(){

        Pokemon pikachu = new Pokemon("Pichu", new Electric(), 1, 0);
        pikachu.addAbility(new Ability("Static"));
        pikachu.addEvolution(new Pokemon("Pikachu", new Electric(), 0, 10));
        pikachu.addEvolution(new Pokemon("Raichu", new Electric(), 0, 15));
        assertEquals("Pikachu, Electric, 10\nRaichu, Electric, 15", pikachu.getEvolutionsInformation());
    }

}
