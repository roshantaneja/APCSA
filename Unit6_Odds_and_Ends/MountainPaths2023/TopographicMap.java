import acm.graphics.*;
import java.awt.Color;
import acm.program.*;


public class TopographicMap
{
    // private instance variables
    private double[][] mapData;
    private boolean valid;

    public TopographicMap(String filename, int rows, int cols)
    {
        // you'll do this in task #1
    }

    public boolean isValid() {return valid;}
    
    private double findMinimum()
    {
        // you'll do this in task #3
        return 0; // just to get it to compile
    }

    private double findMaximum()
    {
        // you'll do this in task #3
        return 0; // just to get it to compile
    }

    public void drawMap(GraphicsProgram graphics)
    {

        double min = this.findMinimum();
        double max = this.findMaximum();

        // you'll do this in task #4
    }

    public double drawLowestElevPath(GraphicsProgram graphics, int startRow, Color drawColor)
    {
        // you'll do this in task #5 
        return 0; // just to get it to compile
    }

    public int getIndexOfLowestElevPath(GraphicsProgram graphics)
    {
        // you'll do this in task #6 
        return 0; // just to get it to compile
    }
    
}
