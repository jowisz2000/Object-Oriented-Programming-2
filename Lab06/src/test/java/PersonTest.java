import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void checkPesel() {

        assertTrue(new Person("a","b", LocalDate.parse("1972-09-08")).checkPesel(720908333));

        assertFalse(new Person("a","b", LocalDate.parse("1973-09-08")).checkPesel(720908333));
    }

    @Test
    void Person(){
        assertNotEquals(new Person("Radoslaw","Laudanski", LocalDate.parse("1972-09-08")),
                new Person("Radoslaw","Laudanski", LocalDate.parse("1972-09-08")));

        assertNotEquals(new Person("Radoslaw","Laudanski", LocalDate.parse("1972-09-08")),
                new Person("Radoslaw","Laudanski", LocalDate.parse("1972-09-08")));

        assertNotEquals(new Person("Radoslaw","Laudanski", LocalDate.parse("1992-09-08")),
                new Person("Radek","Laudanski", LocalDate.parse("1972-09-08")));

        assertNotEquals(new Person("Radoslaw","Laudanski", LocalDate.parse("1972-09-08")),
                new Person("Radoslaw","Laudanski", LocalDate.parse("1972-09-08")));
    }
}