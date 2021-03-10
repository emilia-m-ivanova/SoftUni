package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        String result;
        try {
            Class<?> clazz = Class.forName("barracksWars.core.commands." + commandName);
            Constructor<?> ctor = clazz.getDeclaredConstructor(String[].class,Repository.class,UnitFactory.class);
            ctor.setAccessible(true);
            Command command = (Command) ctor.newInstance(data, this.repository, this.unitFactory);
            result = command.execute();
        }catch (Exception ex){
            result = ex.getMessage();
        }

        return result;
    }
}
