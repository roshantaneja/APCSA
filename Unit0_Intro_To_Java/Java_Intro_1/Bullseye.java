
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Bullseye extends GraphicsProgram
{
    private static final int NUMRINGS = 10;
    private static final int RINGWIDTH = 20;
    private static final int INITIALX = 260;
    private static final int INITIALY = 210;

    public void run()
    {
        Color myColor = Color.red;
        for (int i = NUMRINGS; i > 0; i--){
            drawCircle(i, myColor);
            if (myColor == Color.red){
                myColor = Color.black;
            } else {
                myColor = Color.red;
            }
        }
    }
    
    public void drawCircle(int i, Color myColor){
        GOval circle = new GOval(INITIALX - i*RINGWIDTH, INITIALY - i*RINGWIDTH, i*2*RINGWIDTH, i*2*RINGWIDTH);
        circle.setFilled(true);
        circle.setColor(myColor);
        add(circle);
    }

}

