
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Traffic extends GraphicsProgram
{
    private static final int NUMTYPES = 8;
    private static final int NUMLANES = 12;
    private static final int VEHICLEHEIGHT = 80;

    public void run()
    {
        setSize(1200, NUMLANES*VEHICLEHEIGHT);
        GImage[] vehicles = new GImage[NUMLANES];
        
        for (int i = 0; i < NUMLANES; i ++) {
            vehicles[i] = new GImage("vehicle" + (int)(Math.random()*NUMTYPES) + ".jpg", (int)(Math.random() * 1200) , VEHICLEHEIGHT * i - 100);
            add(vehicles[i]);
        }
    }

}
