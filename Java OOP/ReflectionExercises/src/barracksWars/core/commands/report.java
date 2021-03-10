package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class report extends Command{
    protected report(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
    }

    @Override
    public String execute() {
        String output = this.getRepository().getStatistics();
        return output;    }
}
