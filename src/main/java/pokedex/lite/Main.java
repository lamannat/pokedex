package pokedex.lite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("pokedex-lite");
        List<Pokemon> pokemones = new ArrayList<>();

        Pokemon p1 = new Pokemon("Pikachu", new Electric(), 30, 10);
        p1.addAbility(new Ability("Hipatrueno"));
        p1.addEvolution(new Pokemon("Raichu", new Electric(), 0, 35));

        Pokemon p2 = new Pokemon("Treecko", new Normal(), 30, 10);
        p2.addAbility(new Ability("Suelta hoja"));
        p2.addAbility(new Ability("Navajazo"));

        Pokemon p3 = new Pokemon("Charmander", new Fire(), 30, 10);
        p3.addAbility(new Ability("Soplar fuego"));
        p3.addEvolution(new Pokemon("Charizard", new Fire(), 0, 35));

        Pokemon p4 = new Pokemon("Onix", new Electric(), 30, 10);
        p4.addAbility(new Ability("Tirar piedras"));

        pokemones.add(p1);
        pokemones.add(p2);
        pokemones.add(p3);
        pokemones.add(p4);


        try {
            FileOutputStream f = new FileOutputStream(new File("Pokemones"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(pokemones);
            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("Pokemones"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            List<Pokemon> pokemonesRecuperados = (List<Pokemon>) oi.readObject();

            for(Pokemon pokemon : pokemonesRecuperados){
                System.out.println(pokemon.getBasicInformation());
                System.out.println(pokemon.getAdvancedInformation());
            }

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
