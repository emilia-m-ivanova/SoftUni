package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import barracksWars.models.units.Archer;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType){
        Unit unit = null;
        try {
            Class<?> clazz = Class.forName(this.UNITS_PACKAGE_NAME +unitType);
            Constructor<?> constructor = clazz.getConstructor();
            unit = (Unit) constructor.newInstance();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return unit;
    }
}
