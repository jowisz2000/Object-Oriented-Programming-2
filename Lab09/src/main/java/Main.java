public class Main {
    public static void main(String[] args){
        BlackJack.Builder builder  = new BlackJack.Builder("admin");
        BlackJack blackJack = builder.build();
        blackJack.play();
    }
}
