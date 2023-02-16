package pl.edu.agh.fis.lab7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StudentTest extends PersonTest{
    protected static final int testingIdNumber = 452236;
    protected static final double testingAverage = 3.67;

    @BeforeEach
    void setUp() {
        p = new Student(testingFirstName, testingLastName, testingIdNumber, testingAverage);
    }

    @Test
    void testConstructor() {
        Student st = (Student) p;
        assertEquals(testingIdNumber, st.getIdNumber());
        assertEquals(testingAverage, st.getAverage());
    }

    @Test
    void testSetAverage() {
        Student st = (Student) p;
        double testingAverage2 = 4.99;
        st.setAverage(testingAverage2);
        assertEquals(testingAverage2, st.getAverage());
    }

    @Test
    void testGreater() {
        assertSame(p, p.greater(p));

        Student p2 = new Student("Agnieszka", "Machowska", 465988, 4.5);
        assertSame(p2, p2.greater(p));
        assertSame(p2, p.greater(p2));

        p2.setAverage(3.0);
        assertSame(p, p2.greater(p));
        assertSame(p, p.greater(p2));

        p2.setAverage(testingAverage);
        assertTrue(p2.greater(p) == p2 || p2.greater(p) == p);
        assertTrue(p.greater(p2) == p2 || p.greater(p2) == p);

//        Person p3 = new Dean("prof.", "Testowy", "Dziekan", 2014, 2015);
//        assertNull(p.greater(p3));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String expectedString = testingFirstName + " " + testingLastName +
                ", id number: " + testingIdNumber +
                ", average: " + testingAverage;
        assertEquals(expectedString, "" + p);
    }
}