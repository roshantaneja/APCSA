
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Stoplight extends GraphicsProgram
{
    private static final double BULB_RADIUS = 60; 
    private static final double WINDOW_WIDTH = 754; 
    private static final double WINDOW_HEIGHT = 492;

    public void run()
    {
         GRect rect = new GRect(WINDOW_WIDTH/2 - BULB_RADIUS, 
                                WINDOW_HEIGHT/2 - BULB_RADIUS * 3,
                                BULB_RADIUS * 2, BULB_RADIUS * 6);
        rect.setFilled(true);
        rect.setColor(Color.gray);
        add(rect);
        
       

        }
    }

}


