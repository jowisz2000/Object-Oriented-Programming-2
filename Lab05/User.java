import java.util.UUID;

/**
 * class that contains some information about user
 */
public class User {
    /** user's id*/
    private final UUID id;
    /** user's email*/
    private String email;
    /** user's password*/
    private String password;
    /** variable that holds user's personal information */
    private Person person;

    /**
     * Constructor
     * @param idToSet id to set
     * @param emailToSet email to set
     * @param passwordToSet password to set
     * @param personToSet personal information to set
     */
    User(UUID idToSet, String emailToSet, String passwordToSet, Person personToSet){
        id = idToSet;
        email = emailToSet;
        password = passwordToSet;
        person = personToSet;
    }

    /**
     * overrriden toString method
     * @return data stored in object formatted to string
     */
    @Override
    public String toString(){
        return id+","+email+","+password+","+person;
    }

    /**
     * id's getter
     * @return id
     */
    UUID getID(){return id;}
    /**
     * email's getter
     * @return email
     */
    String getEmail(){return email;}
    /**
     * password's getter
     * @return password
     */
    String getPassword(){return password;}

    /**
     * enables to set new password
      * @param passwordToSet new password
     */
    void setPassword(String passwordToSet){password=passwordToSet;}

    /**
     * enables to set new email
     * @param emailToSet new email
     */
    void setEmail(String emailToSet){email=emailToSet;}


    /**
     * person's getter
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * enables to set new user's personal information
     * @param person new personal data to set
     */

    public void setPerson(Person person) {
        this.person = person;
    }
}
