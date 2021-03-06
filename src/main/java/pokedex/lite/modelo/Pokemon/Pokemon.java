package pokedex.lite.modelo.Pokemon;

import pokedex.lite.modelo.Ability;
import pokedex.lite.modelo.Type.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pokemon implements Serializable {

    protected String name;
    protected Integer level;
    protected Type type;
    protected List<Pokemon> evolutions;
    protected List<Ability> abilities;

    public Pokemon(){}

    public Pokemon(String name, Type type, Integer level){
        evolutions = new ArrayList<>();
        abilities = new ArrayList<>();
        this.name = name;
        this.level = level;
        this.type = type;
    }


    public String getBasicInformation() {
        return name+", "+type.toString()+", "+level.toString();
    }

    public boolean hasName(String aName) {
        return this.name.equals(aName);
    }

    public String getAdvancedInformation() {

        String evolutionsString = evolutions.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        String abilitiesString = abilities.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

        return "Evolutions: "+ evolutionsString + ", Abilities: " + abilitiesString;
    }

    public String getName() {
        return name;
    }

    public Type getType() {

        return type;
    }

    public Integer getLevel() {
        return level;
    }

    public void addAbility(Ability aAbility){
        this.abilities.add(aAbility);
    }

    public void addEvolution(Pokemon aEvolution){
        this.evolutions.add(aEvolution);
    }

    public String toString(){
        return this.name;
    }

    public String getEvolutionsInformation() {

        String evolutionsString = evolutions.stream().map(Pokemon::getBasicInformation)
                .collect(Collectors.joining("\n"));
        return evolutionsString;
    }

    public void editName(String newName) {
        this.name = newName;
    }

    public void editType(Type type) {
        this.type = type;
    }

    public void editLevel(int level) {
        this.level = level;
    }
}
