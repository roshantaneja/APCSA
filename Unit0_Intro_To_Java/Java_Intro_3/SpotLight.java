
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SpotLight extends GraphicsProgram
{
    private static final double RADIUS = 25;
    GOval light;

    public void run()
    {

        light = new GOval(0,0,RADIUS*2,RADIUS*2);
        light.setFilled(true);
        light.setColor(Color.yellow);
        add(light);
    }

    public void mouseMoved(MouseEvent event)
    {
        light.setLocation(event.getX() - RADIUS, event.getY() - RADIUS);
    }

}
