package pokedex.lite.modelo.Pokemon;

import pokedex.lite.modelo.Type.Type;

import java.util.ArrayList;

public class Evolution extends Pokemon{ //an Evolution is a Pokemon but the level represents the level needed to reach the evolution

    public Evolution(String name, Type type, Integer level){
        this.name = name;
        this.level = level;
        this.type = type;
    }
}
