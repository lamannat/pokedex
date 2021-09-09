package pokedex.lite.modelo;

import java.io.Serializable;

public class Ability implements Serializable {

    private String name;

    public Ability (String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
