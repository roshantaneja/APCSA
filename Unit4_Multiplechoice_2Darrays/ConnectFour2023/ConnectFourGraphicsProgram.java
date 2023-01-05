
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ConnectFourGraphicsProgram extends GraphicsProgram
{
    private static final int PIECE_DIAM = 100;
    private static final int NUM_COLS = 7;
    private static final int NUM_ROWS = 6;
    public static final int APPLICATION_WIDTH = NUM_COLS * PIECE_DIAM;
    public static final int APPLICATION_HEIGHT = NUM_ROWS * PIECE_DIAM;

    /** Dimensions of game board in pixels (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;


    private ConnectFourGame game;
    private boolean gameIsBeingPlayed;
    private Color currentDrawingColor;

    
    public void run()
    {
        currentDrawingColor = Color.RED;
        
        game = new ConnectFourGame(NUM_ROWS, NUM_COLS);
        gameIsBeingPlayed = true;
        while (game.getWinner()==0)
        {
            pause(10);
        }
        gameIsBeingPlayed = false;
        
        // add code here in version 0.4
    }

    public void mouseClicked(MouseEvent event) 
    { 
        if (!gameIsBeingPlayed) 
            return;
    
    }
    
    public void drawChecker(int row, int col)
    {
        // complete this in version 0.3
    }


}
