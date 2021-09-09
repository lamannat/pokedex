package pokedex.lite;

import pokedex.lite.modelo.Pokedex;
import pokedex.lite.modelo.Pokemon.Pokemon;

import java.io.*;
import java.util.List;

public class FileInterface implements Reportable{

    private String fileName;
    private Pokedex pokedex;

    public FileInterface(String name, Pokedex pokedex){
        this.fileName = name;
        this.pokedex = pokedex;
    }

    public void readAndLoadPokedex() throws IOException, ClassNotFoundException {

        InputStream fi = getClass().getResourceAsStream(fileName);
        ObjectInputStream oi = new ObjectInputStream(fi);

        List<Pokemon> readedPokemons = (List<Pokemon>) oi.readObject();

        oi.close();
        fi.close();

        this.pokedex.addAllPokemon(readedPokemons);
    }

    public void writeFromPokedex() throws IOException {

        FileOutputStream f = new FileOutputStream(new File(fileName));
        ObjectOutputStream o = new ObjectOutputStream(f);

        o.writeObject(pokedex.getPokemons());
        o.close();
        f.close();
    }

    @Override
    public void notifyDB() throws IOException {
         this.writeFromPokedex();
    }
}
