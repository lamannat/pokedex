package pokedex.lite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Pokedex;
import pokedex.lite.modelo.Pokemon.Evolution;
import pokedex.lite.modelo.Pokemon.Pokemon;
import pokedex.lite.modelo.Type.*;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("pokedex-lite:\n");
        Pokedex pokedex = new Pokedex();
        FileInterface fileDB = new FileInterface("pokemonsDB", pokedex);
        pokedex.addDatabase(fileDB);
        try {
            fileDB.readAndLoadPokedex();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(args.length > 0){
           parseArguments(args, pokedex);
        }
        else{
            System.out.println("Use -help to see the command list");
        }
    }

    private static void parseArguments(String[] args, Pokedex pokedex) throws IOException {

        switch(args[0]){
            case "-help":
                System.out.println("-list: Show all pokemons from database");
                System.out.println("-add: Allow to add a new pokemon to database");
                System.out.println("-get-info \"pokemon's name\": Returns basic information for a specific pokemon");
                System.out.println("-get-advanced-info \"pokemon's name\": Returns evolutions and abilities information for a specific pokemon");
                System.out.println("-get-evolutions-info \"pokemon's name\": Returns all the evolutions information for a specific pokemon");
                System.out.println("-change-name \"pokemon's actual name\" \"pokemon's new name\": Allows to change the name of specific Pokemon");
                System.out.println("-change-type \"pokemon's name\" \"pokemon's new type\": Allows to change the type to a specific Pokemon");
                System.out.println("-change-level \"pokemon's name\" \"pokemon's new level\": Allows to change the level to a specific Pokemon");
                System.out.println("-add-evolution \"pokemon's name\" : Allows to add a new evolution to a specific Pokemon");
                System.out.println("-add-ability \"pokemon's name\" \"ability's name\": Allows to add a new ability to a specific Pokemon");
                break;

            case "-list":
                System.out.println(pokedex.listPokemons());
                break;

            case "-add":
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter pokemon's name: \n");
                String name = scanner.nextLine();
                System.out.println("Enter pokemon's Type: \n");
                Type type = parseType(scanner.nextLine());
                System.out.println("Enter pokemon's level: \n");
                Integer level = Integer.valueOf(scanner.nextLine());
                try {
                    pokedex.addPokemon(new Pokemon(name, type, level));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case "-get-info":
                if(args.length != 2){
                    System.out.println("use: -get-info \"pokemon's name\"");
                }
                else{
                    System.out.println(pokedex.getPokemonBasicInformation(args[1]));
                }
                break;

            case "-get-advanced-info":
                if(args.length != 2){
                    System.out.println("use: -get-advanced-info \"pokemon's name\"");
                }
                else{
                    System.out.println(pokedex.getPokemonAdvanceInformation(args[1]));
                }
                break;

            case "-get-evolutions-info":
                if(args.length != 2){
                    System.out.println("use: -get-evolutions-info \"pokemon's name\"");
                }
                else{
                    System.out.println(pokedex.getPokemonEvolutionsInformation(args[1]));
                }
                break;

            case "-change-name":
                if(args.length != 3){
                    System.out.println("use: -change-name \"pokemon's actual name\" \"pokemon's new name\"");
                }
                else{
                    pokedex.editPokemonName(args[1], args[2]);
                }
                break;

            case "-change-type":
                if(args.length != 3){
                    System.out.println("use: -change-Type \"pokemon's name\" \"pokemon's new Type\"");
                }
                else{
                    pokedex.editPokemonType(args[1], parseType(args[2]));
                }
                break;

            case "-change-level":
                if(args.length != 3){
                    System.out.println("use: -change-level \"pokemon's name\" \"pokemon's new level\"");
                }
                else{
                    pokedex.editPokemonLevel(args[1], Integer.parseInt(args[2]));
                }
                break;

            case "-add-evolution":
                if(args.length != 2){
                    System.out.println("use: -add-evolution \"pokemon's name\"");
                }
                else{

                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Enter evolution's name: \n");
                    String nameEv = scanner2.nextLine();
                    System.out.println("Enter evolution's Type: \n");
                    Type typeEv = parseType(scanner2.nextLine());
                    System.out.println("Enter evolution's required level: \n");
                    Integer levelEv = Integer.valueOf(scanner2.nextLine());
                    try {
                        pokedex.addPokemonEvolution(args[1],new Evolution(nameEv, typeEv, levelEv));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                break;

            case "-add-ability":
                if(args.length != 3){
                    System.out.println("use: -add-ability \"pokemon's name\" \"pokemon's new ability\"");
                }
                else{
                    pokedex.addPokemonAbility(args[1], args[2]);
                }
                break;

            default:
                System.out.println("Use -help to see the command list");
        }
    }

    private static Type parseType(String type) {

        switch(type) {
            case "Normal":
                return new Normal();
            case "Rock":
                return new Rock();
            case "Metal":
                return new Metal();
            case "Fire":
                return new Fire();
            case "Water":
                return new Water();
            case "Psychic":
                return new Psychic();
            case "Grass":
                return new Grass();
            case "Electric":
                return new Electric();
            default:
                return null;
        }
    }


    public void createFileWithPokemons(){

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
