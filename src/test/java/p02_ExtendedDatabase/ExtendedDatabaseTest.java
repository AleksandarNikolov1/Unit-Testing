package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ExtendedDatabaseTest {

    private static final int PERSON_ID = 1;
    private static final String PERSON_USERNAME = "Aleks";

    private Database db;
    private Person person;

    @Before
    public void setUp() throws OperationNotSupportedException {

        person = new Person(PERSON_ID, PERSON_USERNAME);
        db = new Database(person);
    }

    @Test
    public void testAddOperationAddingPersonToDbCorrectly() {
        Person addedPerson = db.getElements()[0];

        assertEquals(1, db.getElements().length);
        assertEquals(person.getId(), addedPerson.getId());
        assertEquals(person.getUsername(), addedPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddFailsWhenAddingNullAsPersonToDb() throws OperationNotSupportedException {
        Person person = null;
        db.add(person);
    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void testAddOperationShouldFailIfMultipleUsersWithSameId() throws OperationNotSupportedException {
//        Person invalidPerson = new Person(PERSON_ID, "Ivan");
//        db.add(invalidPerson);
//    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void testAddOperationShouldFailIfNegativeIdIsPresent() throws OperationNotSupportedException {
//        Person invalidPerson = new Person(-1, PERSON_USERNAME);
//        db.add(invalidPerson);
//    }

//    @Test(expected = OperationNotSupportedException.class)
//    public void testAddOperationShouldFailIfNullIdIsPresent() throws OperationNotSupportedException {
//        Person invalidPerson = new Person(null, PERSON_USERNAME);
//        db.add(invalidPerson);
//    }

    @Test
    public void testRemoveOperationRemovingLastPersonFromDb() throws OperationNotSupportedException {

        Person newPerson = new Person(2, "Ivan");

        db.add(newPerson);

        assertEquals(2, db.getElements().length);

        db.remove();

        assertEquals(1, db.getElements().length);
        assertEquals(person, db.getElements()[0]);
    }

    @Test
    public void testFindPersonDbByUsername() throws OperationNotSupportedException {
        Person foundPerson = db.findById(PERSON_ID);
        assertEquals(person, foundPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindPersonWithNoExistingUsername() throws OperationNotSupportedException {
        String invalidName = "Grigor";
        db.findByUsername(invalidName);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindPersonWithNullUsername() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testFindPersonByCaseSensitiveUsername() throws OperationNotSupportedException {
        db.findByUsername(PERSON_USERNAME.toUpperCase());
    }

    @Test
    public void testFindPersonById() throws OperationNotSupportedException {
        Person foundPerson = db.findById(PERSON_ID);
        assertEquals(person, foundPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByInvalidIdShouldFails() throws OperationNotSupportedException {
        db.findById(PERSON_ID + 1);
    }
}
