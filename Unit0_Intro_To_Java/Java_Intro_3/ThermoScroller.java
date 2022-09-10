
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class ThermoScroller extends GraphicsProgram
{
    private static final double BUTTON_SIZE = 60;
    private static final double OFFSET = 100;
    private static final double WINDOW_WIDTH = 754;
    private static final double WINDOW_HEIGHT = 492;
    
    GRect blueBox;
    GRect redBox;
    GLabel label;
    
    Thermostat therm;

    public void run()
    {
        initializeVariables();
        animationLoop();
    }

    public void initializeVariables()
    {
        blueBox = new GRect(OFFSET, OFFSET, BUTTON_SIZE, BUTTON_SIZE);
        blueBox.setColor(Color.blue);
        blueBox.setFilled(true);
        add(blueBox);
        
        redBox = new GRect(WINDOW_WIDTH - OFFSET - BUTTON_SIZE, OFFSET, BUTTON_SIZE, BUTTON_SIZE);
        redBox.setColor(Color.red);
        redBox.setFilled(true);
        add(redBox);
        
        therm = new Thermostat(60, 120);
        
        label = new GLabel("Temperature = " + therm.getValue(), 0, WINDOW_HEIGHT - OFFSET);
        add(label);
        
        therm = new Thermostat(60, 120);
    }
    
    public void animationLoop()
    {
        while (true){
            if (label.getX() > WINDOW_WIDTH + 5){
                label.move(-WINDOW_WIDTH - label.getWidth() - 5,0);
            }
            pause(10);
            label.move(1, 0);
        }
    }
    
    public void mouseClicked(MouseEvent event){
        if (getElementAt(event.getX(), event.getY()) == blueBox) {
            therm.colder();
            label.setText("Temperature = " + therm.getValue());
        } else if (getElementAt(event.getX(), event.getY()) == redBox) {
            therm.warmer();
            label.setText("Temperature = " + therm.getValue());
        } else if (getElementAt(event.getX(), event.getY()) == redBox) {
            label.setColor(Color.pink);
        } else {
            label.setColor(Color.black);
        }
    }
}
