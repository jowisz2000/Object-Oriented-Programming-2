package pl.edu.agh.fis.lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeanTest extends PersonTest {
    private static final int testingStartYear = 2016;
    private static final int testingEndYear = 2020;
    private static final String testingDegree = "prof. hab. inz.";

    @BeforeEach
    void setUp() {
        p = new Dean(testingDegree, testingFirstName, testingLastName, testingStartYear, testingEndYear);
    }

    @Test
    void testConstructor() {
        Dean dean = (Dean) p;
        assertEquals(testingStartYear, dean.getStartYear());
        assertEquals(testingEndYear, dean.getEndYear());
        assertSame(testingDegree, dean.getDegree());
    }

    @Test
    void setDegree() {
        Dean dean = (Dean) p;
        String testingDegree2 = "dr";
        dean.setDegree(testingDegree2);
        assertSame(testingDegree2, dean.getDegree());
    }

    @Test
    void setEndYear() {
        Dean dean = (Dean) p;
        int testingEndYear2 = 2022;
        dean.setEndYear(testingEndYear2);
        assertEquals(testingEndYear2, dean.getEndYear());
    }

    @Test
    void testGreater() {
        assertSame(p, p.greater(p));
        Dean d2 = new Dean("prof.", "Agnieszka", "Machowska", 1992, 1998);
        assertSame(d2, d2.greater(p));
        assertSame(d2, p.greater(d2));

        d2.setEndYear(1992);
        assertSame(p, d2.greater(p));
        assertSame(p, p.greater(d2));

        d2.setEndYear(testingEndYear-testingStartYear);
        assertTrue(d2.greater(p) == d2 || d2.greater(p) == p);
        assertTrue(p.greater(d2) == d2 || p.greater(d2) == p);

        Person p3 = new Student("Testowy", "Student", 888888, 2.0);
        assertNull(p.greater(p3));
    }

    @Test
    void testToString() {
        String expectedString = testingDegree + " " +
                testingFirstName + " " + testingLastName +
                ", Dean of the Faculty from " + testingStartYear +
                " to " + testingEndYear;
        assertEquals(expectedString, "" + p);
    }
}