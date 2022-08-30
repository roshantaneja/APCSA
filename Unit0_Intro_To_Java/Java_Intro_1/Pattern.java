
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Pattern extends GraphicsProgram
{
    private static final double STARTX = 60;
    private static final double STARTY = 40;
    private static final int NUMSTRIPES = 12;
    private static final double WIDTH = 380;
    private static final double STRIPEHEIGHT = 20;

    public void run()
    {
        Color myColor = Color.red;
        for (int i = 0; i < NUMSTRIPES; i++){
            //createStripe(i);
            GRect stripe = new GRect(STARTX, STARTY + i * STRIPEHEIGHT, WIDTH, STRIPEHEIGHT);
            stripe.setColor(myColor);
            if (myColor == Color.red){
                myColor = Color.pink;
            } else {
                myColor = Color.red;
            }
            stripe.setFilled(true);
            add(stripe);
        }
    }
    
    public static void createStripe(int i){
        GRect stripe = new GRect(STARTX, STARTY + i * STRIPEHEIGHT, WIDTH, STRIPEHEIGHT);
        stripe.setFilled(true);
        //add(stripe);
    }

}
