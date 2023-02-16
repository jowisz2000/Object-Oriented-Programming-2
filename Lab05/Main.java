
public class Main {
    public static void main(String[] args) {
        Read i = new Read();
        User[] tmp = i.toRead("shop.csv");
        for(User k:tmp)
            System.out.println(k);
    }
}