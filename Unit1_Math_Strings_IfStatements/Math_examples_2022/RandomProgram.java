//Roshan Taneja
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RandomProgram extends GraphicsProgram
{
    private static final int BRICK_HEIGHT = (int)((Math.random() * 20) + 10);
    private static final int BRICK_WIDTH = (int)((Math.random() * 10) + 10);
    private static final int NUM_ROWS = (int)((Math.random() * 30) + 5);
    private static final int GAP = (int)((Math.random() * 5) + 5);
    private static final int START_X = 50;
    private static final int START_Y = 50;
    
    public void run()
    {
        /*Repurposed the pyramid project for this program because
           was intregued as to if i could make it such that each
           brick was a different color but the constants were also
           randomly generated making it such that the pyramid was 
           randomized but uniform while each instance of a brick 
           had local properties that were also randomized.*/
        for(int i=0; i<NUM_ROWS; i++) {
            double shift = (NUM_ROWS-i) * (BRICK_WIDTH + GAP)/2 ;
            for(int j=0; j<i; j++){
                Color randColor = new Color((int) (Math.random() * 256),(int) (Math.random() * 256),(int) (Math.random() * 256));
                GRect brick = new GRect(j*(BRICK_WIDTH + GAP) + START_X + shift, i*(BRICK_HEIGHT + GAP) + START_Y, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setColor(randColor);
                add(brick);
            }
        }
    }
}
