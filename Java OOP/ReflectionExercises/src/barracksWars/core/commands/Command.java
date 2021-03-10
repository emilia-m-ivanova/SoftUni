package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory factory;

    protected Command(String[] data, Repository repository, UnitFactory factory) {
        this.data = data;
        this.repository = repository;
        this.factory = factory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getFactory() {
        return this.factory;
    }
}
