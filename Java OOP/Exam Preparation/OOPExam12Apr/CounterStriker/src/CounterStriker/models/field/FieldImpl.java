package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field{
    @Override
    public String start(Collection<Player> players) {
        Set<Player> terrorists = new LinkedHashSet<>();
        Set<Player> counterTerrorists = new LinkedHashSet<>();
        for (Player player : players) {
            if(player.getClass().getSimpleName().equals("Terrorist")){
                terrorists.add(player);
            }else{
                counterTerrorists.add(player);
            }
        }

        String result = "";

        while (!terrorists.isEmpty() && !counterTerrorists.isEmpty()){
            for (Player terrorist : terrorists) {
                for (Player counterTerrorist : counterTerrorists) {
                    int shotsFired = terrorist.getGun().fire();
                    counterTerrorist.takeDamage(shotsFired);
                    if(!counterTerrorist.isAlive()){
                        counterTerrorists.remove(counterTerrorist);
                    }
                }
            }

            for (Player counterTerrorist : counterTerrorists) {
                for (Player terrorist : terrorists) {
                    int shotsFired = counterTerrorist.getGun().fire();
                    terrorist.takeDamage(shotsFired);
                    if(!terrorist.isAlive()){
                        terrorists.remove(terrorist);
                    }
                }

            }

            if(terrorists.isEmpty()){
                result = COUNTER_TERRORIST_WINS;
            }

            if(counterTerrorists.isEmpty()){
                result = TERRORIST_WINS;
            }

        }
        return result;
    }


}
