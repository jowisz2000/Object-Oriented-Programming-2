import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    Card[] cards;

    public Deck() {
        int index=0;
        cards = new Card[Suit.values().length*Rank.values().length];
        for(int i=0; i<Suit.values().length; i++){
            for(int j=0; j<Rank.values().length; j++){
                cards[index]=new Card(Suit.values()[i], Rank.values()[j]);
                index++;
            }
        }
    }

    Card lastCard(){
        Card toReturn = cards[cards.length-1];
        cards = Arrays.copyOf(cards, cards.length-1);
        return toReturn;
    }


    void shuffle(){
        for(int i=0; i<100; i++){
            Random random = new Random();
            int index1 = random.nextInt(cards.length);
            int index2 = random.nextInt(cards.length);
            Card tmpCard = cards[index1];
            cards[index1] = cards[index2];
            cards[index2] = tmpCard;
        }
    }

    @Override
    public String toString() {
        StringBuilder tmp= new StringBuilder();
        for(Card i:cards){
            tmp.append(i.toString()).append("\n");
        }
        return tmp.toString();
    }
}
