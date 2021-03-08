package MilitaryElite;

import MilitaryElite.Interfaces.Engineer;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs(){
        return Collections.unmodifiableCollection(this.repairs);
    }

    @Override
    public String toString() {
        return (super.toString() + System.lineSeparator() + "Repairs:" + System.lineSeparator() +
                this.getRepairs().stream()
                        .map(e->"  " + e.toString())
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
