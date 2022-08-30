import acm.program.*; 
import acm.graphics.*; 
import java.awt.Color;
import java.awt.Font;

public class ConstantExample extends GraphicsProgram 
{
    private static final double BOX_WIDTH = 70; 
    private static final double BOX_HEIGHT = 30; 
    private static final double WINDOW_WIDTH = 754;
    private static final double WINDOW_HEIGHT = 492;

    public void run() 
    {
        GRect redBox = new GRect(WINDOW_WIDTH/2 - BOX_WIDTH/2, WINDOW_HEIGHT/2 - BOX_HEIGHT/2, BOX_WIDTH, BOX_HEIGHT);
        redBox.setFilled(true);
        redBox.setColor(Color.red);
        add(redBox);
        
        GOval greenOval = new GOval(WINDOW_WIDTH/2 - BOX_WIDTH/2, WINDOW_HEIGHT/2 - BOX_HEIGHT/2, BOX_WIDTH, BOX_HEIGHT);
        greenOval.setFilled(true);
        greenOval.setColor(Color.green);
        add(greenOval);
    }
}
