package pokedex.lite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Pokedex;
import pokedex.lite.modelo.Pokemon.Evolution;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        System.out.println("pokedex-lite");
        Pokedex pokedex = new Pokedex();
        FileInterface fileDB = new FileInterface("/pokemonsDB", pokedex);
        pokedex.addDatabase(fileDB);
        fileDB.readAndLoadPokedex();
        System.out.println(pokedex.listPokemons());

//        Pokemon mew = new Pokemon("Mew", new Psychic(), 100);
//        Ability synchroniza = new Ability("Synchronize");
//        mew.addAbility(synchroniza);
//        pokedex.addPokemon(mew);

//        List<Pokemon> pokemons = new ArrayList<>();
//
//        Pokedex pokedex = new Pokedex();
//        FileInterface fileDB = new FileInterface("pokemonsDB", pokedex);
//        pokedex.addDatabase(fileDB);
//
//        Pokemon ivysaur = new Pokemon("Ivysaur", new Grass(), 6);
//        Pokemon venasaur = new Evolution("Venasaur", new Grass(), 13);
//
//        Ability overgrow = new Ability("Overgrow");
//
//        ivysaur.addAbility(overgrow);
//        ivysaur.addEvolution(venasaur);
//
//        pokedex.addPokemon(ivysaur);
//
//
//        Pokemon squirtle = new Pokemon("Squirtle", new Water(), 7);
//        Pokemon wartortle = new Evolution("Wartortle", new Water(), 14);
//        Pokemon blastoise = new Evolution("Blastoise", new Water(), 20);
//
//        Ability torrent = new Ability("Torrent");
//
//        squirtle.addAbility(torrent);
//        squirtle.addEvolution(wartortle);
//        squirtle.addEvolution(blastoise);
//
//        pokedex.addPokemon(squirtle);
//
//        Pokemon pichu = new Pokemon("Pichu", new Electric(), 5);
//        Evolution pikachu = new Evolution("Pikachu", new Electric(), 10);
//        Evolution raichu = new Evolution("Raichu", new Electric(), 15);
//
//        pichu.addEvolution(pikachu);
//        pichu.addEvolution(raichu);
//
//        Ability static_ = new Ability("Static");
//        Ability lightningRod = new Ability("Lightning Rod ");
//
//        pichu.addAbility(static_);
//
//        pokemons.add(pichu);
//
//        Pokemon charmander = new Pokemon("Charmander", new Fire(), 8);
//        Evolution charmaleon = new Evolution("Charmaleon", new Fire(), 12);
//        Evolution charizard = new Evolution("Charizard", new Fire(), 15);
//
//        charmander.addEvolution(charmaleon);
//        charmander.addEvolution(charizard);
//
//        Ability blaze = new Ability("Blaze");
//
//        charmander.addAbility(blaze);
//
//        pokemons.add(charmander);
//
//        Pokemon onix = new Pokemon("Onix", new Rock(), 22);
//        Evolution steelix = new Evolution("Steelix", new Metal(), 30);
//
//        onix.addEvolution(steelix);
//
//        Ability sturdy = new Ability("Sturdy");
//        Ability rockHead = new Ability("Rock Head");
//
//        onix.addAbility(sturdy);
//        onix.addAbility(rockHead);
//
//        pokemons.add(onix);
//
//        Pokemon gyarados = new Pokemon("Gyarados", new Water(), 55);
//        gyarados.addAbility(new Ability("Intimidate"));
//
//        pokemons.add(gyarados);
//
//        Pokemon treecko = new Pokemon("Treecko", new Grass(), 9);
//        Evolution grovyle = new Evolution("Grovyle", new Grass(), 16);
//        Evolution sceptile = new Evolution("Sceptile", new Grass(), 23);
//
//        treecko.addEvolution(grovyle);
//        treecko.addEvolution(sceptile);
//
//        treecko.addAbility(overgrow);
//
//        pokemons.add(treecko);
//
//        Pokemon rattata = new Pokemon("Rattata", new Normal(), 3);
//        Evolution raticate = new Evolution("Raticate", new Normal(), 8);
//
//        rattata.addEvolution(raticate);
//
//        Ability guts = new Ability("Guts");
//        Ability runAway = new Ability("Run Away");
//
//        rattata.addAbility(guts);
//        rattata.addAbility(runAway);
//
//        pokemons.add(rattata);
//
//        pokedex.addAllPokemon(pokemons);
//
//        Pokemon snorlax = new Pokemon("Snorlax", new Normal(), 24);
//
//        Ability thickFat = new Ability("Thick Fat");
//        Ability immunity = new Ability("Immunity");
//
//        snorlax.addAbility(thickFat);
//        snorlax.addAbility(immunity);
//
//        pokedex.addPokemon(snorlax);
//
//        Pokemon mew = new Pokemon("Mew", new Grass(), 100);
//        Ability synchroniza = new Ability("Synchronize");
//        mew.addAbility(synchroniza);
//        pokedex.addPokemon(mew);
    }

}
