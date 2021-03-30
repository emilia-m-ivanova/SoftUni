package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    private ComputerManager manager;
    private Computer[] computers = {
            new Computer("A", "B", 1.5),
            new Computer("A", "BB", 2.5),
            new Computer("C", "D", 2.5),
            new Computer("E", "F", 3.5),
    };
    private Computer nonExisting = new Computer("G", "H", 3.5);

    @Before
    public void setUp() {
        this.manager = new ComputerManager();
    }

    @Test
    public void getComputers() {
        this.addComputers();
        List<Computer> computersList = manager.getComputers();
        for (int i = 0; i < computers.length; i++) {
            assertEquals("Correct computer", computers[i], computersList.get(i));
        }
        assertEquals("Correct size", computers.length, computersList.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getComputersUnmodifiable() {
        this.addComputers();
        List<Computer> computersList = manager.getComputers();
        computersList.remove(0);
    }

    @Test
    public void getCount() {
        int count = manager.getCount();
        assertEquals("Correct size empty", 0, count);
        this.addComputers();
        count = manager.getCount();
        assertEquals("Correct size with entries", computers.length, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerThrowsWithNullValue() {
        manager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerThrowsWithExistingEntity() {
        this.addComputers();
        manager.addComputer(computers[0]);
    }

    @Test
    public void removeComputer() {
        this.addComputers();
        for (Computer computer : computers) {
            Computer removeComputer = manager.removeComputer(computer.getManufacturer(), computer.getModel());
            assertEquals("Correct computer removed",computer,removeComputer);
        }
        List<Computer> computersLeft = manager.getComputers();
        assertEquals("Collection is empty",0,computersLeft.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeComputerThrowsForNonExisting() {
        this.addComputers();
        manager.removeComputer(nonExisting.getManufacturer(),nonExisting.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerThrowsForNonExisting() {
        this.addComputers();
        manager.getComputer(nonExisting.getManufacturer(),nonExisting.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerThrowsForNullManufacturer() {
        this.addComputers();
        manager.getComputer(null,nonExisting.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerThrowsForNullModel() {
        this.addComputers();
        manager.getComputer(nonExisting.getManufacturer(),null);
    }

    @Test
    public void getComputer() {
        this.addComputers();
        for (Computer computer : computers) {
            Computer resultComputer = manager.getComputer(computer.getManufacturer(), computer.getModel());
            assertEquals("Correct computer",computer,resultComputer);
        }
    }

    @Test
    public void getComputersByManufacturer() {
        this.addComputers();
        List<Computer> resultComputers = manager.getComputersByManufacturer("A");
        for (int i = 0; i < resultComputers.size(); i++) {
            assertEquals(computers[i],resultComputers.get(i));
        }
        assertEquals(2,resultComputers.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputersByManufacturerThrowsForNull() {
        manager.getComputersByManufacturer(null);
    }

    private void addComputers() {
        for (Computer computer : this.computers) {
            this.manager.addComputer(computer);
        }

    }
}