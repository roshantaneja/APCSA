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
    public static final int LAVA = 5;
    public static final int CONWAY = 6;
    
    public static final int ROCK = 1000;
    public static final int STEAM = 1001;
    

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
        names = new String[7];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "Sand";
        names[WATER] = "Water";
        names[ICE] = "Ice";
        names[LAVA] = "Lava";
        names[CONWAY] = "Conway's Game of Life";
        
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
        else if (particleType == LAVA)
            grid[row][col] = new Lava();
        else if (particleType == CONWAY)
            grid[row][col] = new Conway();
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        int row = (int)(Math.random() * grid.length);
        int col = (int)(Math.random() * grid[0].length);
        Particle particle = grid[row][col];
        //step methods per particle
        if (particle.getType() == EMPTY){
            return;
        } else if (particle.getType() == METAL){
            if (numNeighbors(row, col, LAVA) > 3){
                grid[row][col] = new Lava();
            }
            return;
        } else if (particle.getType() == SAND) {
            tryToMoveDown(row, col, true);
            return;
        } else if (particle.getType() == WATER) {
            if (numNeighbors(row, col, LAVA) > 3){
                grid[row][col] = new Steam();
            }
            waterBehaviour(row, col);
        } else if (particle.getType() == STEAM){
            int direction = (int)(Math.random() * 10);
            if (direction > 5 && direction < 7){
                tryToMoveUp(row, col, true);
            } else if (direction == 8){
                tryToMoveLeft(row, col);
            } else if (direction == 9) {
                tryToMoveRight(row, col);
            }
            Steam steam = (Steam)(particle);
            if (row == 0) {
                steam.increment();
            }
            if (steam.hasCondensed()){
                grid[row][col] = new Water();
            }
            return;
        } else if (particle.getType() == ICE) {
            Ice ice = (Ice)(particle);
            ice.increment();
            if (ice.hasMelted()){
                grid[row][col] = new Water();
            }
            return;
        } else if (particle.getType() == LAVA) {
            Lava lava = (Lava)(particle);
            lava.increment();
            waterBehaviour(row, col);
            if (lava.hasHardened()){
                grid[row][col] = new Rock();
            }
            return;
        } else if (particle.getType() == CONWAY) {
            conwayBehaviour();
            return;
        }
    }
    
    public void waterBehaviour(int row, int col){
        int direction = (int)(Math.random() * 10);
        if (direction <= 7) {
            tryToMoveDown(row, col, true);
        } else if (direction == 8) {
            tryToMoveLeft(row, col);
        } else {
            tryToMoveRight(row, col);
        }
    }
    
    public void conwayBehaviour(){
        for (int row = 0; row < grid.length; row ++){
            for (int col = 0; col < grid[0].length; col ++){
                int n = numNeighbors(row, col, CONWAY);
                if (grid[row][col].getType() == CONWAY && (n == 2 || n == 3)){
                    grid[row][col] = new Conway();
                } else if (grid[row][col].getType() != CONWAY && n == 3){
                    grid[row][col] = new Conway();
                } else if (grid[row][col].getType() == CONWAY && (n < 2 || n > 3)){
                    grid[row][col] = new Empty();
                } 
            }
        }
    }

    private int numNeighbors(int r, int c, int type)
    {
        int total = 0;
        if (r != 0 && grid[r-1][c].getType() == type) // top
            total ++;
        if (r !=  grid.length - 1 && grid[r+1][c].getType() == type) // bottom
            total ++;
        if (c != 0 && grid[r][c-1].getType() == type) // left
            total++;
        if (c !=  grid[0].length - 1 && grid[r][c+1].getType() == type) // right
            total++;
        if (r != 0 && c != 0 && grid[r-1][c-1].getType() == type) // top left
            total++;
        if (r != 0 && c != grid[0].length - 1 && grid[r-1][c+1].getType() == type) // top right
            total++;
        if (r != grid.length - 1 && c != 0 && grid[r+1][c-1].getType() == type) // bottom left
            total++;
        if (r != grid.length - 1 && c != grid[0].length - 1 && grid[r+1][c+1].getType() == type) // bottom right
            total++;
        return total;
    }

    public void tryToMoveUp(int row, int col, boolean canFallThroughWater){
        if (row != 0 && (grid[row - 1][col].getType() == EMPTY ||
                canFallThroughWater && grid[row - 1][col].getType() == WATER || grid[row - 1][col].getType() == STEAM)) {
            Particle save = grid[row][col];
            grid[row][col] = grid[row - 1][col];
            grid[row - 1][col] = save;
        } else if (row != 0 && col != 0 && (grid[row - 1][col - 1].getType() == EMPTY ||
                canFallThroughWater && grid[row - 1][col - 1].getType() == WATER || grid[row - 1][col - 1].getType() == STEAM)){
            Particle save = grid[row][col];
            grid[row][col] = grid[row - 1][col - 1];
            grid[row - 1][col - 1] = save;
        } else if (row != 0 && col != grid[0].length - 1 && (grid[row - 1][col + 1].getType() == EMPTY ||
                canFallThroughWater && grid[row - 1][col + 1].getType() == WATER || grid[row - 1][col + 1].getType() == STEAM)){
            Particle save = grid[row][col];
            grid[row][col] = grid[row - 1][col + 1];
            grid[row - 1][col + 1] = save;
        }
    }

    public void tryToMoveDown(int row, int col, boolean canFallThroughWater){
        if (row != grid.length - 1 && (grid[row + 1][col].getType() == EMPTY ||
                canFallThroughWater && grid[row + 1][col].getType() == WATER || grid[row + 1][col].getType() == STEAM)){
            Particle save = grid[row][col];
            grid[row][col] = grid[row + 1][col];
            grid[row + 1][col] = save;
        } else if (row != grid.length - 1 && col != grid[0].length - 1 && (grid[row+1][col + 1].getType() == EMPTY ||
                canFallThroughWater && grid[row + 1][col + 1].getType() == WATER || grid[row + 1][col + 1].getType() == STEAM)) {
            Particle save = grid[row][col];
            grid[row][col] = grid[row + 1][col + 1];
            grid[row + 1][col + 1] = save;    
        } else if (row != grid.length - 1 && col != 0 && (grid[row+1][col - 1].getType() == EMPTY ||
                canFallThroughWater && grid[row + 1][col - 1].getType() == WATER || grid[row + 1][col - 1].getType() == STEAM)) {
            Particle save = grid[row][col];
            grid[row][col] = grid[row + 1][col - 1];
            grid[row + 1][col - 1] = save;    
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
