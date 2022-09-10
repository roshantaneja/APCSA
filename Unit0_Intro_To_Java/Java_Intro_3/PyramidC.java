import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PyramidC extends GraphicsProgram
{
    private static final int BRICK_HEIGHT = 1;
    private static final int BRICK_WIDTH = 2;
    private static final int GAP = 2;
    private static final int NUM_ROWS = 100;
    private static final int START_X = 50;
    private static final int START_Y = 50;

    public void run()
    {
        
        for(int i=0; i<NUM_ROWS; i++){
            double shift = (NUM_ROWS-i) * (BRICK_WIDTH + GAP)/2 ;
            for(int j=0; j<i; j++){
                GRect brick = new GRect(j*(BRICK_WIDTH + GAP) + START_X + shift, i*(BRICK_HEIGHT + GAP) + START_Y, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                add(brick);
            }
        }
    }
}
