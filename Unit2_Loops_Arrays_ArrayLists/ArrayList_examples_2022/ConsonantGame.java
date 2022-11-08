
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class ConsonantGame extends GraphicsProgram
{
    private ArrayList<GLabel> labels;
    private RandomWordGenerator generator;
    private int turns;

    public void run()
    {
        labels = new ArrayList<GLabel>();
        generator = new RandomWordGenerator();
        turns = 0;
        // fill up labels with 25 random labels here
        // play the game and tell me how many turns it took
        // to win here
        for (int i=0; i<25; i++)
        {
            GLabel label = getRandomLabel();
            labels.add(label);
        }
        
    }

    public void keyPressed(KeyEvent event)
    {
        String letter = KeyEvent.getKeyText(event.getKeyCode()).toUpperCase();  
        // handle one key press here
    }

    public GLabel getRandomLabel()
    {
        /* Return a GLabel, with a random word, random
           location, random color, and random font size.
           It should be added 
        */
       GLabel result = new GLabel(generator.getRandomWord(),
                       (int)(Math.random() * getWidth()),
                       (int)(Math.random() * getHeight()));
       Color color = new Color((int)(Math.random() * 256), 
                               (int)(Math.random() * 256),
                               (int)(Math.random() * 256));
       result.setColor(color);
       int size = (int)(Math.random() * 53 + 12);
       result.setFont("*-*-" + size);
       add(result);
       return result;
    }

}
