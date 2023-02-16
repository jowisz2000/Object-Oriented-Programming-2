import java.util.UUID;

/**
 * klasa przechowujaca dane uzytkownika
 */
public class User {
    /** id uzytkownika*/
    private final UUID id;
    /** email uzytkownika*/
    private String email;
    /** haslo uzytkownika*/
    private String password;
    /** dane osobowe uzytkownika*/
    Person person;

    /**
     * Konstruktor klasy User
     * @param idToSet id uzytkownika
     * @param emailToSet email uzytkownika
     * @param passwordToSet haslo uzytkownika
     * @param personToSet dane osobowe uzytkownika
     */
    User(UUID idToSet, String emailToSet, String passwordToSet, Person personToSet){

        assert idToSet!=null : "id jest nullem";
        assert emailToSet!=null : "email jest nullem";
        assert passwordToSet.isEmpty() : "password jest nullem";
        assert personToSet!=null : "person jest nullem";
        assert emailToSet.contains("@"): "niepoprawny fromat emaila";

        id = idToSet;
        email = emailToSet;
        password = passwordToSet;
        person = personToSet;
    }

    /**
     * Przeciazona metoda toString
     * @return dane przechowywane w obiekcie User w formie Stringa
     */
    @Override
    public String toString(){
        return id+","+email+","+password+","+person;
    }

    /**
     * getter zmiennej id
     * @return id uzytkownika
     */
    UUID getID(){return id;}
    /**
     * getter zmiennej email
     * @return email uzytkownika
     */
    String getEmail(){return email;}
    /**
     * getter zmiennej password
     * @return haslo uzytkownika
     */
    String getPassword(){return password;}

    /**
     * pozwala zmienic haslo
     * @param passwordToSet nowe haslo
     */
    void setPassword(String passwordToSet){
        assert !passwordToSet.isEmpty(): "Puste hasło!";
        password=passwordToSet;
    }

    /**
     * pozwala zmienic email uzytkownika
     * @param emailToSet nowy email
     */
    void setEmail(String emailToSet){
        assert emailToSet.contains("@"): "Niewłaściwy format maila!";
        email=emailToSet;
    }

    void setPerson(Person toSet){
        assert toSet!=null: "obiekt klasy Person jest nullem!";
        person = toSet;
    }
}
