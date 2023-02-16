import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BlackJack {
    private final String name;
    private int maxIter;
    private int userValue;
    private int computerValue;
    private Deck deck;

    public static class Builder{
        private final String name;
        private int maxIter = 100;
        private int userValue=0;
        private int computerValue = 0;

        private final Deck deck;

        public Builder(String name){
            this.name=name;
            this.deck = new Deck();
        }

        public Builder setMaxIter(int maxIter){
            this.maxIter=maxIter;
            return this;
        }

        public Builder setUserValue(int userValue){
            this.userValue+=userValue;
            return this;
        }

        public Builder setComputerValue(int computerValue){
            this.computerValue+=computerValue;
            return this;
        }

        public int getUserValue() {
            return userValue;
        }

        public int getComputerValue() {
            return computerValue;
        }

        public int getMaxIter() {
            return maxIter;
        }

        public BlackJack build(){
            return new BlackJack(this);
        }
    }

    public void play(){
        deck.shuffle();
        BlackJack.Builder players = new BlackJack.Builder("Admin");
        int numberOfIterations = 0;
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in) );
        try {
            String s="notEmpty";
            while(!s.equals("QUIT") && players.getMaxIter()>numberOfIterations) {
                System.out.print( "Prosze cos wpisac : (QUIT-wyjscie z gry, PLAY - dalsza gra, STOP - przerwanie gry)\n");
                s = stdin.readLine();
                if(s.equals("PLAY")){
                    players.setComputerValue(deck.lastCard().getRank().getRank()).setUserValue(deck.lastCard().getRank().getRank());
                    System.out.println("Uzytkownik: "+players.getUserValue()+", komputer: " +players.getComputerValue());

                    if(players.getComputerValue()>21){
                        System.out.println("Komputer przekroczyl 21!");
                        break;
                    }
                    if(players.getUserValue()>21){
                        System.out.println("Uzytkownik przekroczyl 21!");
                        break;
                    }
                    if(players.getUserValue()==21){
                        System.out.println("Uzytkownik wygrywa!");
                        break;
                    }
                    if(players.getComputerValue()==21){
                        System.out.println("Komputer wygrywa!");
                        break;
                    }
                }

                if(s.equals("STOP")){
                    System.out.println("Koniec gry!");
                    int userScore = Math.abs(players.getUserValue()-21);
                    int computerScore = Math.abs(players.getComputerValue()-21);
                    if(userScore>computerScore){
                        System.out.println("Wygrywa komputer!");
                    }
                    else if(userScore<computerScore){
                        System.out.println("Wygrywa uzytkownik!");
                    }
                    else{
                        System.out.println("Remis!");
                    }
                    break;
                }
                numberOfIterations++;
            }
        }
        catch( Throwable e ) { System.out.println( "Bledny odczyt ze strumienia wejscia!" ); }
    }

    private BlackJack(Builder builder){
        name = builder.name;
        maxIter = builder.maxIter;
        userValue = builder.userValue;
        computerValue = builder.userValue;
        deck = builder.deck;
    }
}
