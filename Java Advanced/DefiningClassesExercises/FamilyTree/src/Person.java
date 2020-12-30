import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name = "";
    private String birthday = "";
    private Set<Person> parents = new LinkedHashSet<>();
    private Set<Person> children = new LinkedHashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public Set<Person> getParents() {
        return parents;
    }

    public Set<Person> getChildren() {
        return children;
    }
}
