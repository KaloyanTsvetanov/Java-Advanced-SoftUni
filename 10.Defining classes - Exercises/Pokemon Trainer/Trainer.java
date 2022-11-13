import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Trainer {

    private String name;
    private int badges;
    private int numPoke;
    private Set<Pokemon> pokemonList = new LinkedHashSet<>();

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.pokemonList.add(pokemon);
        this.numPoke = pokemonList.size();
    }

    public boolean checkElement(String element) {
        for (Pokemon a : pokemonList) {
            if (a.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name+" "+getBadges()+" "+this.numPoke;
    }

    public boolean checkHealth(){
        for(var a: pokemonList){
            int b = a.getHealth();
            if(b<=0){
                this.numPoke-=1;
            }
        }
        return true;
    }

    public void setLoss() {
        for (var a : pokemonList) {
            int h = a.getHealth();
            a.setHealth(h-10);
        }
    }
    public void setWin() {
        badges += 1;
        setBadges(badges);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public Set<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(Set<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setNumPoke(int numPoke) {
        this.numPoke = numPoke;
    }

    public int getNumPoke() {
        return numPoke;
    }
}
