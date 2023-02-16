import java.time.LocalDate;

/**
 * Klasa przechowujaca dane poszczegolnej osoby
 */
public final class Person {
    /** imie danej oosby*/
    private final String firstName;
    /** nazwisko danej osoby*/
    private final String lastName;
    /** data urodzenia danej osoby*/
    private final LocalDate dateOfBirth;

    /**
     * Konstruktor klasy Person
     * @param fNameToSet imie danej osoby
     * @param lNameToSet nazwisko danej osoby
     * @param dateOfBirthToSet data urodzenia osoby
     */
    Person(String fNameToSet, String lNameToSet,LocalDate dateOfBirthToSet){
        assert fNameToSet!=null : "fname jest nullem";
        assert fNameToSet!="" : "fname jest pusty!";
        assert lNameToSet!=null : "lname jest nullem";
        assert lNameToSet!="" : "lname jest pusty!";
        assert dateOfBirthToSet!=null : "data jest nullem";
        assert dateOfBirthToSet.getYear()>1900: "zbyt wczesny rok!";
        assert dateOfBirthToSet.getYear()<2000: "zbyt pozny rok!";


        firstName = fNameToSet;
        lastName = lNameToSet;
        dateOfBirth = dateOfBirthToSet;
    }

    /**
     * getter zmiennej firstName
     * @return firstName
     */
    String getFirstName(){return firstName;}

    /**
     * getter zmiennej lastName
     * @return lastName nazwisko osoby
     */
    String getLastName(){return lastName;}


    /**
     * getter zmiennej dateOfBirth
     * @return dateOfBirth nazwisko osoby
     */
    LocalDate getDateOfBirth(){return dateOfBirth;}


    /**
     * Przeladowona metoda toString
     * @return dane przechowywane w obiekcie person jako String
     */
    @Override
    public String toString(){
        return firstName+","+lastName+","+dateOfBirth;
    }

    boolean checkPesel(long pesel){
        assert pesel>10100000: "Zbyt maly nr pesel!";
        assert pesel<99123199999L: "Zbyt duzy pesel!";
        String a = ""+pesel;
        int peselYear = 1900+Character.getNumericValue(a.charAt(0))*10+Character.getNumericValue(a.charAt(1));
        int peselMonth = Character.getNumericValue(a.charAt(2))*10+Character.getNumericValue(a.charAt(3));
        int peselDay = Character.getNumericValue(a.charAt(4))*10+Character.getNumericValue(a.charAt(5));

        return peselYear==dateOfBirth.getYear() && peselMonth==dateOfBirth.getMonthValue() && peselDay==dateOfBirth.getDayOfMonth();
    }


}


