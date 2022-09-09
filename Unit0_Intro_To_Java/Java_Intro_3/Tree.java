
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Tree extends GraphicsProgram
{

    public void run()
    {
        GRect trunk;
        trunk = new GRect(45, 50, 20, 100);
        trunk.setFilled(true);
        trunk.setColor(Color.yellow);
        add(trunk);

        GOval leaves;
        leaves = new GOval(35, 15, 50, 50);
        leaves.setFilled(true);
        leaves.setColor(Color.green);
        add(leaves);
        
        GLabel description = new GLabel("This is a tree.", 20, 180);
        description.setColor(Color.red);
        description.setFont("Palatino-Bold-24");
        add(description);
        
        GImage cheese;
        cheese = new GImage("grilledcheese.jpg", 200, 250);
        add(cheese);

    }

}
