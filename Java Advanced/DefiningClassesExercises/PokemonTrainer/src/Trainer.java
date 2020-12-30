import java.util.LinkedHashSet;
import java.util.Set;

public class Trainer {

    private String name;
    private int badges;
    private Set<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new LinkedHashSet<>();
        this.badges = 0;
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void increaseBadges(){
        this.badges++;
    }

    @Override
    public String toString() {
        return this.name + " " + this.badges + " " + this.pokemons.size();
    }
}
