
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class KlickForKate extends GraphicsProgram
{

    public void run()
    {

    }
    
    public void mouseMoved(MouseEvent event)
    {
        GImage kate;
        kate = new GImage("kate.jpg", event.getX(), event.getY());
        add(kate);
    }

}
