package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;
import javax.naming.OperationNotSupportedException;
import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Person[] PEOPLE = {new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third"),
            new Person(4, "Fourth")};
    private static final Person TEST_PERSON = new Person(5, "Test person");
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    //constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testArrayCapacityIs16integers() throws OperationNotSupportedException {
        Person[] arr = new Person[17];
        new Database(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCannotBeEmpty() throws OperationNotSupportedException {
        new Database();
    }

    //add
    @Test(expected = OperationNotSupportedException.class)
    public void addFailsWithElementNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addFailsWithNegativeID() throws OperationNotSupportedException {
        database.add(new Person(-1, "Test person"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addFailsWithExistingID() throws OperationNotSupportedException {
        database.add(new Person(1, "Test person"));
    }

    @Test
    public void addsSuccessfully() throws OperationNotSupportedException {
        database.add(TEST_PERSON);
        Person[] elements = database.getElements();
        Person actual = elements[elements.length - 1];
        assertEquals(TEST_PERSON.getId(), actual.getId());
        assertEquals(TEST_PERSON.getUsername(), actual.getUsername());
    }

    //remove
    @Test
    public void removesElementsCorrectly() throws OperationNotSupportedException {
        database.remove();
        Person[] people = database.getElements();
        assertEquals(PEOPLE.length - 1, people.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeThrowsExceptionIfCollectionIsEmpty() throws OperationNotSupportedException {
        for (int i = 0; i < 5; i++) {
            database.remove();
        }
    }

    //find by username
    @Test
    public void findByUsername() throws OperationNotSupportedException {
        Person actual = database.findByUsername("First");
        assertEquals("First", actual.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameFailsWithNullParam() throws OperationNotSupportedException {
        database.findByUsername(null);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameFailsWithNotRegisteredUsername() throws OperationNotSupportedException {
        database.findByUsername("Test");
    }


    //find by ID
    @Test
    public void findById() throws OperationNotSupportedException {
        Person actual = database.findById(1);
        assertEquals(1, actual.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdFailsWithNoRegisteredId() throws OperationNotSupportedException {
        database.findById(5);
    }

}