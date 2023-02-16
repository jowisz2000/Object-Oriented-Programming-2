import java.time.LocalDate;

/**
 * Class that contains info about person
 */
public final class Person {
    /** person's first name*/
    private final String firstName;
    /** person's last name*/
    private final String lastName;
    /** person's date of birth*/
    private final LocalDate dateOfBirth;

    /**
     * Constructor
     * @param fNameToSet first name to set
     * @param lNameToSet last name to set
     * @param dateOfBirthToSet date of birth to set
     */
    Person(String fNameToSet, String lNameToSet,LocalDate dateOfBirthToSet){
        firstName = fNameToSet;
        lastName = lNameToSet;
        dateOfBirth = dateOfBirthToSet;
    }

    /**
     * first name's getter
     * @return firstName
     */
    String getFirstName(){return firstName;}

    /**
     * last names's getter
     * @return lastName
     */
    String getLastName(){return lastName;}


    /**
     * date of birth's getter
     * @return dateOfBirth
     */
    LocalDate getDateOfBirth(){return dateOfBirth;}


    /**
     * Overrided toString method
     * @return data from object as String
     */
    @Override
    public String toString(){
        return firstName+","+lastName+","+dateOfBirth;
    }
}
