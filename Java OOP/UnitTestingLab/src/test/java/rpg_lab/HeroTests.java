package rpg_lab;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Interfaces.Target;
import rpg_lab.Interfaces.Weapon;


public class HeroTests {

    private static final int TARGET_XP = 10;
    @Test
    public void heroGetsXPWhenTargetIsDead(){
        Target testTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {}

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        Weapon testWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 10;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero("test",testWeapon);
        hero.attack(testTarget);
        assertEquals(TARGET_XP,hero.getExperience());
    }
}
