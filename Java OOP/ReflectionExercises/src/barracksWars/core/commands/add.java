package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class add extends Command {
    protected add(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        try {
            Unit unitToAdd = this.getFactory().createUnit(unitType);
            this.getRepository().addUnit(unitToAdd);
        }catch (Exception ex){
            return ex.getMessage();
        }
        String output = unitType + " added!";
        return output;
    }

}
