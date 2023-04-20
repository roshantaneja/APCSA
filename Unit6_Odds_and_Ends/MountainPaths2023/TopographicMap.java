import acm.graphics.*;
import java.awt.Color;
import acm.program.*;


public class TopographicMap
{
    // private instance variables
    private double[][] mapData;
    private boolean valid;

    public TopographicMap(String fileName, int rows, int cols)
    {
        // you'll do this in task #1
        valid = true;
        mapData = new double[rows][cols];
        double[] data = FileHelper.readDataFromFile(fileName, rows * cols);
        if (data.length == 0){
            valid = false;
        } else {
            //use data to fill mapdata
            int index = 0;
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    mapData[i][j] = data[index];
                    index++;
                }
            }
        }
    }

    public boolean isValid() {return valid;}
    
    private double findMinimum()
    {
        double min = mapData[0][0];
        for (for int i = 0; i < mapData.length; i++){
            for (int j = 0; j < mapData[i].length; j++){
                if (mapData[i][j] < min){
                    min = mapData[i][j];
                }
            }
        }
        return min; // just to get it to compile
    }

    private double findMaximum()
    {
        double max = mapData[0][0];
        for (int i = 0; i < mapData.length; i++){
            for (int j = 0; j < mapData[i].length; j++){
                if (mapData[i][j] > max){
                    max = mapData[i][j];
                }
            }
        }
        return max;
    }

    public void drawMap(GraphicsProgram graphics)
    {
        double min = this.findMinimum();
        double max = this.findMaximum();


        for (int i = 0; i < mapData.length; i++){
            for (int j = 0; j < mapData[i].length; j++){
                double value = mapData[i][j];
                double scaledValue = (value - min) / (max - min);
                GRect rect = new GRect(j, i, 1, 1);
                rect.setFilled(true);
                rect.setFillColor(new Color((float)scaledValue, (float)scaledValue, (float)scaledValue));
                graphics.add(rect);
            }
        }

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
