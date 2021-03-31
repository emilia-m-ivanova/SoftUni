package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    private static String USERNAME = "Test";
    private static int HEALTH = 5;
    private Player player;
    private static Gun[] guns = {
            new Gun("A", 1),
            new Gun("B", 2),
            new Gun("C", 3)
    };
    private static Gun nonExisting = new Gun("D", 1);

    @Before
    public void setUp() {
        this.player = new Player(USERNAME, HEALTH);
    }

    @Test
    public void constructorWithZeroHealth() {
        Player test = new Player("Test", 0);
        assertEquals(0,test.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithNegativeHealthThrows() {
        new Player("Test",-1);
    }

    @Test(expected = NullPointerException.class)
    public void constructorWithEmptyNameThrows() {
        new Player("",0);
    }

    @Test(expected = NullPointerException.class)
    public void constructorWithNullNameThrows() {
        new Player(null,0);
    }

    @Test
    public void getUsername() {
        assertEquals(USERNAME, player.getUsername());
    }

    @Test
    public void getHealth() {
        assertEquals(HEALTH, player.getHealth());
    }

    @Test
    public void getGuns() {
        this.addGuns();
        List<Gun> gunsResult = player.getGuns();
        for (int i = 0; i < gunsResult.size(); i++) {
            assertEquals(guns[i], gunsResult.get(i));
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getGunsUnmodifiable() {
        this.addGuns();
        List<Gun> gunsResult = player.getGuns();
        gunsResult.remove(0);
    }

    @Test
    public void takeDamage() {
        player.takeDamage(2);
        assertEquals(HEALTH - 2, player.getHealth());
        player.takeDamage(5);
        assertEquals(0,player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageThrows() {
        player.takeDamage(5);
        player.takeDamage(5);
    }

    @Test
    public void removeGun() {
        this.addGuns();
        for (Gun gun : guns) {
            boolean removed = player.removeGun(gun);
            assertTrue(removed);
        }
        assertEquals(0, player.getGuns().size());
    }

    @Test
    public void getGun() {
        this.addGuns();
        for (Gun gun : guns) {
            Gun gunResult = player.getGun(gun.getName());
            assertEquals(gun, gunResult);
        }
        assertNull(player.getGun(nonExisting.getName()));
    }

    @Test(expected = NullPointerException.class)
    public void addGunThrowsForNull(){
        player.addGun(null);
    }

    private void addGuns() {
        for (Gun gun : guns) {
            player.addGun(gun);
        }
    }
}