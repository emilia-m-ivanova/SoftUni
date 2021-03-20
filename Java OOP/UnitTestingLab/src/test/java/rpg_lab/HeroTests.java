package rpg_lab;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Interfaces.Target;
import rpg_lab.Interfaces.Weapon;


public class HeroTests {

    private static final int TARGET_XP = 10;

    @Test
    public void heroGetsXPWhenTargetIsDead(){

        Target target = Mockito.mock(Target.class);
        Weapon weapon = Mockito.mock(Weapon.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero("test",weapon);
        hero.attack(target);
        assertEquals(TARGET_XP,hero.getExperience());
    }
}
