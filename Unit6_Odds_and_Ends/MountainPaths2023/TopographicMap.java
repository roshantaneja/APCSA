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
        
        double[] data = FileHelper.readDataFromFile(fileName, rows * cols);
        if (data.length == 0){
            valid = false;
        } else {
            //use data to fill mapdata
            mapData = new double[rows][cols];
            int index = 0;
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    mapData[i][j] = data[index];
                    index++;
                }
            }
            valid = true;
        }
    }

    public boolean isValid() {return valid;}
    
    private double findMinimum()
    {
        double min = mapData[0][0];
        for (int i = 0; i < mapData.length; i++){
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
        System.out.println(min + " " + max);
        for (int i = 0; i < mapData.length; i++){
            for (int j = 0; j < mapData[i].length; j++){
                double value = mapData[i][j];
                int gray = (int)((value - min) / (max - min) * 255);
                GRect rect = new GRect(j, i, 1, 1);
                rect.setColor(new Color(gray, gray, gray));
                rect.setFilled(true);
                graphics.add(rect);
            }
        }
        // you'll do this in task #4
    }

    public int drawLowestElevPath(GraphicsProgram graphics, int startRow, Color drawColor){
        // you'll do this in task #7
        return 0;
    }

    //assess between all three coordinates to the left and pick the one with the least elevation change from your current position, return either 0, 1, or 2 based on the choice

    
}
