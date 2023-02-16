package pl.edu.agh.fis.lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class GraduateTest extends StudentTest {
    private static final LocalDate testingGraduationDate = LocalDate.now();

    @BeforeEach
    void setUp() {
        p = new Graduate(testingFirstName, testingLastName, testingIdNumber, testingAverage,
                testingGraduationDate);
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        Graduate gr = (Graduate) p;
        assertSame(testingGraduationDate, gr.getGraduationDate());
    }

    @Test
    void testToString() {
        String expectedString = testingFirstName + " " + testingLastName +
                ", id number: " + testingIdNumber +
                ", average: " + testingAverage +
                ", graduation date: " + testingGraduationDate;
        assertEquals(expectedString, "" + p);
    }
}