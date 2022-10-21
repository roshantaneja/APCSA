
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class HangmanGraphicsProgram extends GraphicsProgram
{
/** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 800;
    public static final int APPLICATION_HEIGHT = 500;
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
    
    private static final int PUZZLE_Y_OFFSET = 100;
    private static final int GUESSED_LETTERS_X_OFFSET = 50;
    private static final int GUESSED_LETTERS_Y_OFFSET = 300;
     
    // task #0 - familiarize yourself with the private instance variables below
    private GLabel puzzleLabel;
    private GLabel lettersGuessedLabel;
    private HangmanGame game;

    public void run()
    {
        game = new HangmanGame();
        
        puzzleLabel = new GLabel(game.getPuzzle());
        int fontSize = 64;
        puzzleLabel.setFont("Monospaced-plain-"+fontSize);
        // the while loop below makes the puzzle as large as possible so that it fits
        while(puzzleLabel.getWidth()>WIDTH)
        {
            fontSize--;
            puzzleLabel.setFont("*-*-"+fontSize);
        }
        puzzleLabel.setLocation((WIDTH-puzzleLabel.getWidth())/2, PUZZLE_Y_OFFSET);
        add(puzzleLabel);
 
        lettersGuessedLabel = new GLabel("Letters guessed: ", GUESSED_LETTERS_X_OFFSET, GUESSED_LETTERS_Y_OFFSET);
        lettersGuessedLabel.setFont("Sansserif-Plain-18");
        lettersGuessedLabel.setColor(Color.red);
        add(lettersGuessedLabel);
        
        // add code here to finish task #2
        
    }
    
    
    public void keyPressed(KeyEvent event)
    {
        String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();  
        // add code here to finish task #1
        
    }


    
}
