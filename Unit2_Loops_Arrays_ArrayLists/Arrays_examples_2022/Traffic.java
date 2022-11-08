
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class Traffic extends GraphicsProgram
{
    private static final int NUMTYPES = 8;
    private static final int NUMLANES = 12;
    private static final int VEHICLEHEIGHT = 80;

    GImage[] vehicles = new GImage[NUMLANES];
    double[] vy = new double[NUMLANES];
    
    public void run()
    {
        setSize(1200, NUMLANES*VEHICLEHEIGHT);
        
        createCars();
        
        while (true) {
            pause(20);
            for (int i = 0; i < vehicles.length; i ++){
                vehicles[i].move(vy[i], 0);
                
                if (vehicles[i].getX() < -vehicles[i].getWidth() ){
                    vehicles[i].setLocation(1200, vehicles[i].getY());
                }
            }
        }
    }
    
    public void createCars(){
        for (int i = 0; i < NUMLANES; i ++) {
            vehicles[i] = new GImage("vehicle" + (int)(Math.random()*NUMTYPES) + ".jpg", (int)(Math.random() * 1200) , VEHICLEHEIGHT * i - 100);
            add(vehicles[i]);
            
            vy[i] = Math.random() * -7;
        }
    }
    
    

}
