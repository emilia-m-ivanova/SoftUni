package MilitaryElite;

import MilitaryElite.Interfaces.Commando;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        return (super.toString() + System.lineSeparator() + "Missions:" + System.lineSeparator() +
                this.missions.stream()
                        .filter(m -> m.getState().toString().equals("inProgress"))
                        .map(e -> "  " + e.toString())
                        .collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
