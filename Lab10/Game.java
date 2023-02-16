import java.util.Scanner;

interface CheckStep {
    boolean check(char[][] board, int i, int j);
}

public class Game {
    private final int size=3;

    private int turn =0;

    public int getTurn() {
        return turn;
    }

    private char[][] array;
    /** odd values for first player, even for second player */
    static private int whichPlayer = 1;

    boolean isWinner = false;

    public static int getWhichPlayer() {
        return whichPlayer;
    }

    boolean checkIndex(char[][] board, int i, int j, CheckStep checkStep){
        return checkStep.check(board, i, j);
    }

    CheckStep function = (char[][] board, int i, int j)-> !(' ' == board[i][j]);


    Game(){
        array = new char[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                array[i][j]=' ';
            }
        }
    }

    public void printArray(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(array[i][j]);
            }
            System.out.print('\n');
        }
    }

    public void getIndexes(){
        Scanner sc = new Scanner(System.in);
        int i, j;
        try{
            System.out.println("Prosze podac 1 wspolrzedna: ");
            i = sc.nextInt();
            System.out.println("Prosze podac 2 wspolrzedna: ");
            j = sc.nextInt();
            if(i<0 || i>2 || j<0 || j>2 || checkIndex(array, i, j, function)) throw new CellNotExistsException();

            if(whichPlayer%2==1) array[i][j]='o';
            else array[i][j]='x';
            whichPlayer++;
            printArray();
            turn++;
        }
        catch(CellNotExistsException e){
            System.out.println("Niewlasciwe indeksy!");
            sc.nextLine();
            getIndexes();
        }
        catch(Exception e){
            System.out.println("Niewlasciwy format!");
            sc.nextLine();
            getIndexes();
        }
    }

    boolean isOver(){

        for(int j=0; j<3; j++){
            if(array[0][j]==array[1][j] && array[1][j]==array[2][j] && array[2][j]!=' '){
                isWinner=true;
                return true;
            }
        }

        for(int i=0; i<3; i++){
            if(array[i][0]==array[i][1] && array[i][1]==array[i][2] && array[i][2]!=' '){
                isWinner=true;
                return true;
            }
        }

        if(array[0][0]==array[1][1] && array[1][1]==array[2][2] && array[2][2]!=' ') {
            isWinner=true;
            return true;
        }

        if(array[0][2]==array[1][1] && array[1][1]==array[2][0] && array[2][0]!=' ') {
            isWinner=true;
            return true;
        }
        return false;
    }

    void printWinner(){
        if(isWinner) {
            System.out.print("Wygral gracz ");
            if (whichPlayer % 2 == 1) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
        else{
            System.out.println("Remis");
        }
    }


}
