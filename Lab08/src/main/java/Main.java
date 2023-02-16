import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        Scanner scanner = new Scanner(new RandomWordAdapter(16, 5));
        while (scanner.hasNext())
            System.out.println(scanner.next());
    }
}
