import java.util.ArrayList;
import acm.program.*;

public class Bogglish extends ConsoleProgram
{
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPRSTUVWXYZ";

    public void run()
    {
        setFont("*-*-24");
        String[][] board = new String[5][5];
        // version 0.1, 0.2, and 0.5 here
    }

    /** Returns true if the word is "contained" somewhere in the board,
     *  following our "Bogglish" rules, false otherwise.
     *  @param word the word to check
     *  @param board the Bogglish board
     *  @return true if the word is in the board, false otherwise.
     */
    private boolean checkWord(String word, String[][] board)
    {
        // version 0.4 here
        return false;
    }

    /** Returns the Position of where the letter is in the board
     *  Note that this returns a Position, which is a class you wrote.
     *  @param letter a String of length 1 representing the letter
     *  @param board the Bogglish board
     *  @return the Position of the letter, or null if it is not there 
     */
    private Position getLetterPosition(String letter, String[][] board)
    {
        // version 0.3 here
        return null;
    }

}
