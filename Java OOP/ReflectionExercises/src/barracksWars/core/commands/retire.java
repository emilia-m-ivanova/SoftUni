package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class retire extends Command {
    protected retire(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
    }

    @Override
    public String execute() {
        try {
            this.getRepository().removeUnit(this.getData()[1]);
        } catch (Exception ex){
            return ex.getMessage();
        }
        return this.getData()[1] + " retired!";
    }
}
