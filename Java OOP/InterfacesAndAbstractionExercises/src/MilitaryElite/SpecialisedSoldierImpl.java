package MilitaryElite;

import MilitaryElite.Interfaces.SpecialisedSoldier;

import java.util.Arrays;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    public void setCorps(String corps) {
        if(Arrays.stream(Corps.values()).noneMatch(v->v.toString().equals(corps))){
            throw new IllegalArgumentException("Invalid corps");
        }
        this.corps = Corps.valueOf(corps);
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + "Corps: " +
                this.corps.toString();
    }
}
