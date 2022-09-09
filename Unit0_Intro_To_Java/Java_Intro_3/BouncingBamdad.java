
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class BouncingBamdad extends GraphicsProgram
{
    GImage natasha;
    double vx;
    double vy;
    
    public void run()
    {
        setup();
        animationLoop();        
    }
    
    public void setup()
    {
        vx = 1.0;
        vy = 1.0;
        natasha = new GImage("natasha.jpg", 100, 100);
        natasha.scale(0.5);
        add(natasha);       
    }
    
    public void animationLoop()
    {
        while (1 < 2)
        {
            pause(5);
            natasha.move(vx, vy);
            if (natasha.getX() > getWidth() - natasha.getWidth() )
            {
                vx = -vx;
            }
            if (natasha.getY() > getHeight() - natasha.getHeight() )
            {
                vy = -vy;
            }
            if (natasha.getY() < 0)
            {
                vy = -vy;
            }
            if (natasha.getX() < 0)
            {
                vx = -vx;
            }
        }
    }
    

}
