
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SpotLight extends GraphicsProgram
{
    private static final double LIGHT_RADIUS = 50;
    GOval light = new GOval(0, 0, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
    public void run()
    {
        light.setFilled(true);
        light.setColor(Color.yellow);
    }
    
    public void mouseMoved(MouseEvent event)
    {
        light.setLocation(event.getX() - LIGHT_RADIUS, event.getY() - LIGHT_RADIUS);
        add(light);
    }
   
}
