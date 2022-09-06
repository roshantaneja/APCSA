
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class BouncingBamdad extends GraphicsProgram
{
    GImage natasha;
    double vX = 1.0;
    double vY = 1.0;
    public void run()
    {
        natasha = new GImage("natasha.jpg", 100, 100);
        natasha.scale(0.5);
        add(natasha);
        
        while (true){
            pause(10);
            natasha.move(vX,vY);
            if (natasha.getX() > getWidth() - natasha.getWidth()){
                vX = -vX;
            }
            if (natasha.getX() < 0){
                vX = -vX;
            }
            if (natasha.getY() > getHeight() - natasha.getHeight()) {
                vY = -vY;
            }
            if (natasha.getY() < 0) {
                vY = -vY;
            }
        }
    }

}
