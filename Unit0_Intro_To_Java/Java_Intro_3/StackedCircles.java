
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class StackedCircles extends GraphicsProgram
{
    private static final double RADIUS = 25;
    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 12;

    public void run()
    {
       for (int i = 0; i < NUM_ROWS; i++) {
           for (int j = 0; j < NUM_COLS; j++){
               GOval circle = new GOval(j * RADIUS * 2, i * RADIUS * 2, RADIUS * 2, RADIUS * 2);
               pause(0.5);
               add(circle);
           }
       }
    }
}
