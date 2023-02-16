import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Class that enables to read data from file
 */
public class Read {
    /**default constructor*/
    Read(){}
    /**
     *
     * @param fileName name of file to read
     * @return usersToReturn array of used that were read from fileName
     */
    User[] toRead(String fileName) {
        int i=-1;
        try {
            BufferedReader f = new BufferedReader(
                    new FileReader(fileName));
            String s;
            while ((s = f.readLine()) != null) {
                i++;
            }
        } catch (Throwable e) {
            System.out.println("Unable to read file!");
        }

        User[] usersToReturn = new User[i];

        try {
            BufferedReader f = new BufferedReader(
                    new FileReader(fileName));
            String s;
            i=0;
            while ((s = f.readLine()) != null) {
                String[] tmpString = s.split(",");

                if(i!=0) {
                    Person tmp = new Person(tmpString[3], tmpString[4], LocalDate.parse(tmpString[5]));
                    usersToReturn[i-1] = new User(UUID.fromString(tmpString[0]), tmpString[1], tmpString[2], tmp);
                }
                i++;
            }

        } catch (Throwable e) {
            System.out.println("Unable to read file!");
        }

        return usersToReturn;
    }
}
