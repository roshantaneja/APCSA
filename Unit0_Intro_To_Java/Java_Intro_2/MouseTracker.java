
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram
{
    private static final int SIZE = 60;

    GLabel label;
    GRect box;

    public void run()
    {
        label = new GLabel("", 50, 50);
        add(label);
        box = new GRect(-1000000, -1000000, SIZE, SIZE);
        box.setColor(Color.orange);
        box.setFilled(true);
        add(box);
    }

    public void mouseMoved(MouseEvent event)
    {
        label.setText("X = " + event.getX() + " Y = " + event.getY());
        if (getElementAt(event.getX(), event.getY()) == label)
        {
            label.setColor(Color.magenta);
        }
        else
        {
            if (getElementAt(event.getX(), event.getY()) == box)
            {
                label.setColor(Color.cyan);
            }
            else
            {
                label.setColor(Color.black);
            }
        }
    }

    public void mouseClicked(MouseEvent event)
    {
        box.setLocation(event.getX()-SIZE/2, event.getY()-SIZE/2);
    }

}
