package pl.edu.agh.fis.lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    protected Person p;
    protected static final String testingFirstName = "Kazimierz";
    protected static final String testingLastName = "Nowak";

    @BeforeEach
    void setUp() {
        p = new Person(testingFirstName, testingLastName) {
            @Override
            public Person greater(Person ob) {
                return null;
            }
        };
    }

    @Test
    void testConstructorAndSetters() {
        assertSame(testingFirstName, p.getFirstName());
        assertSame(testingLastName, p.getLastName());

        String testingFirstName2 = "Franciszek";
        p.setFirstName(testingFirstName2);
        assertSame(testingFirstName2, p.getFirstName());

        String testingLastName2 = "Kowalski";
        p.setLastName(testingLastName2);
        assertSame(testingLastName2, p.getLastName());
    }

    @Test
    void testToString() {
        String expectedString = testingFirstName + " " + testingLastName;
        assertEquals(expectedString, "" + p);
    }
}