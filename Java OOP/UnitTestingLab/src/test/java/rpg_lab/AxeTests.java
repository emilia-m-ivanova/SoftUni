package rpg_lab;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AxeTests {

    private static final int AXE_ATTACK = 1;
    private static final int AXE_DURABILITY = 3;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 1;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void axeLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        assertEquals("Wrong durability",2, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attachWithBrokenAxe() {
        for (int i = 0; i < 3; i++) {
            axe.attack(dummy);
        }
        axe.attack(dummy);
    }
}