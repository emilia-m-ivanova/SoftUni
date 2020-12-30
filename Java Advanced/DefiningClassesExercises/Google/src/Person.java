import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private Set<Child> children;
    private Set<Pokemon> pokemons;
    private Set<Parent> parents;

    public Person(String name) {
        this.name = name;
        this.children = new LinkedHashSet<>();
        this.pokemons = new LinkedHashSet<>();
        this.parents = new LinkedHashSet<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return this.name;
    }

    public Set<Child> getChildren() {
        return this.children;
    }

    public Set<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public Set<Parent> getParents() {
        return this.parents;
    }

    @Override
    public String toString() {
        return this.name + System.lineSeparator() +
                "Company:" + System.lineSeparator() +
                (this.company != null ? this.company + System.lineSeparator() : "") +
                "Car:" + System.lineSeparator() +
                (this.car != null ? this.car + System.lineSeparator() : "") +
                "Pokemon:" + System.lineSeparator() +
                (this.pokemons != null ? this.pokemons.stream()
                        .map(Pokemon::toString)
                        .collect(Collectors.joining()) : "") +
                "Parents:" + System.lineSeparator() +
                (this.parents != null ? this.parents.stream()
                        .map(Parent::toString)
                        .collect(Collectors.joining()) : "") +
                "Children:" + System.lineSeparator() +
                (this.children != null ? this.children.stream()
                        .map(Child::toString)
                        .collect(Collectors.joining()) : "");
    }
}
