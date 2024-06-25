import java.util.*;

class TicTaeToe{

    char[][] board;
    char currentPlayer;

    public TicTaeToe(){ 
        
        board = new char[3][3];
        initBoard();
        currentPlayer = 'x';
    }

    void initBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] = ' ';
            }
        }
    }

    void displayBoard(){
        System.out.println("------------");
        for(int i=0; i<board.length; i++)
        {
            System.out.print("|");
            for(int j=0; j<board[i].length; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------");
        }
       
        

    }

    public boolean placeMark(int row, int col)
    {
        if(row<0 && row>2 && col<0 && col>2)
        {
            System.out.println("Out of position. Enter a valid position.");
            return false;
            }

        if(board[row][col]!=' '){
            System.out.println("This position is already occupied. Enter another position.");
            return false;
        }
        board[row][col]=currentPlayer;
        return true;

    }

    public boolean isBoardFull(){
        for(int i=0; i<=2; i++){
            for(int j=0; j<=2; j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin(){
        return(checkColWin() || checkRowWin() || checkDiaWin());
    }

    private boolean checkColWin(){
        for(int j=0; j<=2; j++)
        {
            if(board[0][j]==currentPlayer && 
            board[0][j]==board[1][j] && board[1][j]==board[2][j])
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkRowWin(){
        for(int i=0; i<=2; i++)
        {
            if(board[i][0]==currentPlayer && 
            board[i][0]==board[i][1] && board[i][1]==board[i][2])
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiaWin(){
        if(board[0][0]==currentPlayer &&
        board[0][0]==board[1][1] && board[1][1]==board[2][2] 
        || board[0][2]==currentPlayer && board[0][2]==board[1][1] && board[1][1]==board[2][0])
        {
            return true;
        }
        return false;
    }

    void changePlyer(){
        currentPlayer = (currentPlayer=='x')? 'o' : 'x';
    }



}

public class Game1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicTaeToe t = new TicTaeToe();

        t.displayBoard();
        System.out.println(t.currentPlayer +" make your move.");

        while (true) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(t.placeMark(row, col)){
                t.displayBoard();

                if(t.checkForWin()){
                    System.out.println(t.currentPlayer + " wins the game.");
                    break;
                }
                else if(t.isBoardFull()){
                    System.out.println("The game is a draw");
                    break;
                }
                t.changePlyer();
                System.out.println(t.currentPlayer + " make your move.");
            }
            else{
                System.out.println("Invalid move. Try again.");
            }
            
            }

    }
}
