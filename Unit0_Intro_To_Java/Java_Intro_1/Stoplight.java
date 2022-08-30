import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Stoplight extends GraphicsProgram
{
    private static final double WINDOW_WIDTH = 754;
    private static final double WINDOW_HEIGHT = 492;
    private static final double STOPLIGHT_HEIGHT = 300;

    public void run()
    {
        drawBase();
        drawAllLights();
    }

    public void drawBase(){
        GRect base = new GRect(WINDOW_WIDTH/2 - STOPLIGHT_HEIGHT/2, 
                               WINDOW_HEIGHT/2 - STOPLIGHT_HEIGHT/2, 
                               STOPLIGHT_HEIGHT/3, 
                               STOPLIGHT_HEIGHT);
        base.setColor(Color.gray);
        base.setFilled(true);
        add(base);
    }
    public void drawAllLights(){
        drawLight(0, Color.green);
        drawLight(1, Color.yellow);
        drawLight(2, Color.red);
    }
    public void drawLight(int i, Color myColor){
        GOval light = new GOval(WINDOW_WIDTH/2 - STOPLIGHT_HEIGHT/2,
                                WINDOW_HEIGHT/2 - STOPLIGHT_HEIGHT/2 + i * (STOPLIGHT_HEIGHT/3),
                                STOPLIGHT_HEIGHT/3, 
                                STOPLIGHT_HEIGHT/3);
        light.setFilled(true);
        light.setColor(myColor);
        add(light);
    }
   
}
