package rpg_lab;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {

    private static final int AXE_ATTACK = 5;
    private static final int AXE_DURABILITY = 5;
    private Dummy deadDummy;
    private Dummy aliveDummy;
    private Axe axe;

    @Before
    public void setUp(){
        this.aliveDummy = new Dummy(10,10);
        this.deadDummy = new Dummy(0,10);
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
    }

    @Test
    public void dummyLosesHealthIfAttacked(){
        axe.attack(aliveDummy);
        assertEquals("Wrong dummy health",5,aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        axe.attack(deadDummy);
    }

    @Test
    public void deadDummyCanGiveXP(){
        assertEquals("Wrong experience",10,deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){
        aliveDummy.giveExperience();
    }
}
