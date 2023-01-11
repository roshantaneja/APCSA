import java.awt.*;
import java.util.*;
import acm.program.*;

public class ParticlesProgram extends Program
{
    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;

    //do not add any more private instance variables
    private Particle[][] grid;
    private ParticlesDisplay display;

    public void init()
    {
        initVariables(120, 80);
    }    

    public void initVariables(int numRows, int numCols)
    {
        String[] names;
        names = new String[2];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
       
        display = new ParticlesDisplay("Particles Game", 
                                        numRows, numCols, names);
        // initialize the grid here (task 0.1)
        
    }

    //called when the user clicks on a location using the given particleType
    private void locationClicked(int row, int col, int particleType)
    {
        // finish this cascading if (task 0.2)
        if (particleType == EMPTY)
            grid[row][col] = new Empty();
        else if (particleType == METAL)
            grid[row][col] = new Metal();          
        
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        
    }
        
    //copies each element of grid into the display (don't modify this)
    public void updateDisplay()
    {
        for (int r=0; r<grid.length; r++)
            for (int c=0; c<grid[0].length; c++)
                display.setColor(r, c, grid[r][c].getColor());
    }

    // repeatedly calls step and updates the display
    // (don't modify this)
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}
