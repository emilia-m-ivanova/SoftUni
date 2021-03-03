package MilitaryElite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LeutenantGeneralImpl extends PrivateImpl {
    private Set<PrivateImpl> set;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.set = new LinkedHashSet<>();
    }

    public void addPrivate(PrivateImpl priv) {
        this.set.add(priv);
    }

    @Override
    public String toString() {
        return (super.toString() + System.lineSeparator() + "Privates:" + System.lineSeparator() +
                set.stream()
                        .map(e->"  "+e.toString())
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
