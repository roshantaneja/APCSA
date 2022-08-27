
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class klickForKate extends GraphicsProgram
{

    public void run()
    {

    }
    
    public void mouseMove(MouseEvent event){
        GImage kate = new GImage("kate.jpg", event.getX(), event.getY());
        add(kate);
    }

}
