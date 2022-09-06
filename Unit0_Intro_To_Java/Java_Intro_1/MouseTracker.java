
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram
{
    GLabel label;
    GRect box;
    private static final int boxSize = 60;

    public void run()
    {
        label = new GLabel("have a nice weekend!", 50, 50);
        add(label);
        box = new GRect(-100, -100, boxSize, boxSize);
        box.setColor(Color.orange);
        box.setFilled(true);
        add(box);
    }
    
    public void mouseMoved(MouseEvent event) {
        label.setText("X = " + event.getX() + ", Y = " + event.getY());
        if (getElementAt(event.getX(), event.getY()) == label){
            label.setColor(Color.magenta);
        } else if (getElementAt(event.getX(), event.getY()) == box) {
            label.setColor(Color.cyan);
        } else {
            label.setColor(Color.black);
        }
    }
    
    public void mouseClicked(MouseEvent event) {
        box.setLocation(event.getX() - boxSize/2, event.getY() - boxSize/2);
    }
}
