
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        while(!game.isOver() && game.getTurn()<9){
            game.getIndexes();
        }
        game.printWinner();
    }
}