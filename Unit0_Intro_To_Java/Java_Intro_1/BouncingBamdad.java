
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class BouncingBamdad extends GraphicsProgram
{
    GImage natasha;
    double vX;
    double vY;
    private static final double SPEED = 0.1;
    
    public void setup(){
        vX = 2.0;
        vY = 1.0;
        natasha = new GImage("natasha.jpg", 100, 100);
        natasha.scale(0.5);
        add(natasha);
    }
    
    public void animationLoop(){
        while (true){
            pause(1/SPEED);
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
    
    public void run()
    {
        setup();
        animationLoop();
    }

}
