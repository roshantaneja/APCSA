import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class PyramidA extends GraphicsProgram
{
    private static final int BRICK_HEIGHT = 12;
    private static final int BRICK_WIDTH = 30;
    private static final int GAP = 4;
    private static final int NUM_ROWS = 10;
    private static final int START_X = 50;
    private static final int START_Y = 60;

    public void run()
    {
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                GRect brick = new GRect(START_X + j * (BRICK_WIDTH + GAP), START_Y + i * (BRICK_HEIGHT + GAP), BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                add(brick);
            }
        }
    }

}
