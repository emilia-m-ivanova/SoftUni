package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class fight extends Command {
    protected fight(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
