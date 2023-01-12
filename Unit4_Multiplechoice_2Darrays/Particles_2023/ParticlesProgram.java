import java.awt.*;
import java.util.*;
import acm.program.*;

public class ParticlesProgram extends Program
{
    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int ICE = 4;
    

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
        names = new String[5];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[ICE] = "Ice";
        
        display = new ParticlesDisplay("Particles Game", 
                                        numRows, numCols, names);
        // initialize the grid here (task 0.1)
        grid = new Particle[numRows][numCols];
        for (int r = 0; r < numRows; r++){
            for (int c = 0; c < numCols; c++){
                grid[r][c] = new Empty();
            }
        }
        
    }

    //called when the user clicks on a location using the given particleType
    private void locationClicked(int row, int col, int particleType)
    {
        // finish this cascading if (task 0.2)
        if (particleType == EMPTY)
            grid[row][col] = new Empty();
        else if (particleType == METAL)
            grid[row][col] = new Metal();
        else if (particleType == SAND)
            grid[row][col] = new Sand();
        else if (particleType == WATER)
            grid[row][col] = new Water();
        else if (particleType == ICE)
            grid[row][col] = new Ice();
        
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        int row = (int)(Math.random() * grid.length);
        int col = (int)(Math.random() * grid[0].length);
        Particle particle = grid[row][col];
        //step methods per particle
        if (particle.getType() == EMPTY || particle.getType() == METAL){
            return;
        } else if (particle.getType() == SAND) {
            tryToMoveDown(row, col, true);
        } else if (particle.getType() == WATER) {
            waterBehaviour(row, col);
        } else if (particle.getType() == ICE) {
            Ice ice = (Ice)(particle);
            ice.increment();
            if (ice.hasMelted()){
                grid[row][col] = new Water();
            }
        }
    }
    
    public void waterBehaviour(int row, int col){
        int direction = (int)(Math.random() * 10);
        if (direction <= 7) {
            tryToMoveDown(row, col, false);
        } else if (direction == 8) {
            tryToMoveLeft(row, col);
        } else {
            tryToMoveRight(row, col);
        }
    }
    
    public void tryToMoveDown(int row, int col, boolean canFallThroughWater){
        if (row != grid.length - 1 && (grid[row+1][col].getType() == EMPTY || 
            canFallThroughWater && grid[row+1][col].getType() == WATER)){
            Particle save = grid[row][col];
            grid[row][col] = grid[row+1][col];
            grid[row+1][col] = save;
        } else if (row != grid.length - 1 && col != grid[0].length - 1 && (grid[row+1][col + 1].getType() == EMPTY || 
            canFallThroughWater && grid[row+1][col + 1].getType() == WATER)) {
            Particle save = grid[row][col];
            grid[row][col] = grid[row+1][col+1];
            grid[row+1][col+1] = save;    
        } else if (row != grid.length - 1 && col != 0 && (grid[row+1][col - 1].getType() == EMPTY || 
            canFallThroughWater && grid[row+1][col + 1].getType() == WATER)) {
            Particle save = grid[row][col];
            grid[row][col] = grid[row+1][col-1];
            grid[row+1][col-1] = save;    
        }
    }
    
    public void tryToMoveLeft(int row, int col){
        if (col != 0 && grid[row][col - 1].getType() == EMPTY){
            Particle save = grid[row][col];
            grid[row][col] = grid[row][col - 1];
            grid[row][col - 1] = save;
        }
    }
    
    public void tryToMoveRight(int row, int col){
        if (col != grid[0].length - 1 && grid[row][col + 1].getType() == EMPTY){
            Particle save = grid[row][col];
            grid[row][col] = grid[row][col + 1];
            grid[row][col + 1] = save;
        }
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
