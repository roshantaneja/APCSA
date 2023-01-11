import java.awt.Color;

public class ConnectFourGame
{
    private int[][] board;
    private int currentTurnNumber;
    
    public ConnectFourGame(int rows, int cols)
    {
        board = new int[rows][cols];
        for (int r = 0; r < board.length; r ++) {
            for (int c = 0; c<board[0].length; c ++){
                board[r][c] = 0;
            }
        }
        // you need to fill board with 0's
        currentTurnNumber = 1;
    }

    // returns 0, 1, or 2
    public int getWinner()
    {      
        // horizontal -
        for (int r = 0; r < board.length; r ++){
            for (int c = 0; c < board[0].length - 3; c++){
                if (board[r][c] != 0 && board[r][c] == board[r][c + 1] &&
                                        board[r][c] == board[r][c + 2] &&
                                        board[r][c] == board[r][c + 3]) {
                    return board[r][c];
                }
            }
        }
        
        //vertical |
        
        for (int r = 0; r < board.length - 3; r ++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] != 0 && board[r][c] == board[r + 1][c] &&
                                        board[r][c] == board[r + 2][c] &&
                                        board[r][c] == board[r + 3][c]) {
                    return board[r][c];
                }
            }
        }
        
        // diagonal /
        for (int r = 0; r < board.length - 3; r ++){
            for (int c = 3; c < board[0].length; c++){
                if (board[r][c] != 0 && board[r][c] == board[r + 1][c - 1] &&
                                        board[r][c] == board[r + 2][c - 2] &&
                                        board[r][c] == board[r + 3][c - 3]) {
                    return board[r][c];
                }
            }
        }
        
        
        // diagonal \
        for (int r = 0; r < board.length - 3; r ++){
            for (int c = 0; c < board[0].length - 3; c++){
                if (board[r][c] != 0 && board[r][c] == board[r + 1][c + 1] &&
                                        board[r][c] == board[r + 2][c + 2] &&
                                        board[r][c] == board[r + 3][c + 3]) {
                    return board[r][c];
                }
            }
        }
        
        return 0; // feel free to eventually change this line.  it is just here so the rest will compile
    }

    // updates the state of the game (board and currentTurnColor)
    // returns the row in which the checker would end up
    // returns -1 if the column col is completely full and no checker can be dropped
    public int dropChecker(int col)
    {
        for (int r = board.length - 1; r >= 0; r --) {
            if (board[r][col] == 0) {
                board[r][col] = currentTurnNumber;
                if (currentTurnNumber == 1){
                    currentTurnNumber = 2;
                } else {
                    currentTurnNumber = 1;
                }
                return r;
            }
        }
        return -1;
    }
}













