import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

//        Person tmp2 = new Person("A", "B", LocalDate.parse("2099-02-02"));
//        Person tmp3 = new Person("A", "B", LocalDate.parse("1899-02-02"));
//        Person tmp= new Person(null, "A", LocalDate.parse("1899-02-02"));
//        Person tmp= new Person("A", null, LocalDate.parse("1899-02-02"));
//        Person tmp= new Person("A", "A", null);
//        Person tmp= new Person("", "A", LocalDate.parse("1899-02-02"));
//        Person tmp= new Person("A", "", LocalDate.parse("1899-02-02"));
        Person tmp = new Person("A", "B", LocalDate.parse("1929-02-02"));
        User u = new User(UUID.fromString("bbec02ef-c02e-467d-bec7-bbfd605b6087"), "a@j", "b", tmp);
    }

}