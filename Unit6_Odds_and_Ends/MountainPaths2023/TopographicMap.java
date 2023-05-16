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
    }

    public double drawLowestElevPath(GraphicsProgram graphics, int startRow, Color drawColor){
        double sum = 0;
        int currentRow = startRow;
        for (int c = 0; c < mapData[0].length - 1; c++){
            double[] choices = new double[3];
            if (currentRow == 0){ // change up
                choices[0] = Integer.MAX_VALUE;
            } else {
                choices[0] = Math.abs(mapData[currentRow][c] - mapData[currentRow - 1][c+1]);
            }
            choices[1] = Math.abs(mapData[currentRow][c] - mapData[currentRow][c + 1]); // change forward
            if (currentRow == mapData.length - 1){ // change down
                choices[2] = Integer.MAX_VALUE;
            } else {
                choices[2] = Math.abs(mapData[currentRow][c] - mapData[currentRow + 1][c+1]);
            }

            int choice;
            if (choices[1] <= choices[0] && choices[1] <= choices[2]){ // if right is good option
                choice = 1;
            } else if (choices[0] < choices[2]){ // if up is good option
                choice = 0;
            } else if (choices[2] < choices[1]){
                choice = 2;
            } else {
                if (Math.random() < 0.5){
                    choice = 0;
                } else {
                    choice = 2;
                }
            }

            if (choice == 0){
                currentRow--;
            } else if (choice == 2){
                currentRow++;
            }

            sum += choices[choice];

            GRect pixel = new GRect(c, currentRow, 1, 1);
            pixel.setColor(drawColor);
            pixel.setFilled(true);
            graphics.add(pixel);
        }
        return sum;
    }

    // use djikstras algorithm to find the shortest path from startRow point on the left to any point on the right
    // return the value of the path based on the cumulative value of altitude change
    public double drawLowestDownhillPath(GraphicsProgram graphics, int startRow, Color drawColor){
        double sum = 0;
        int currentRow = startRow;
        for (int c = 0; c < mapData[0].length - 1; c++){
            double[] choices = new double[3];
            if (currentRow == 0){ // change up
                choices[0] = Integer.MAX_VALUE;
            } else {
                choices[0] = mapData[currentRow][c] - mapData[currentRow - 1][c+1];
            }
            choices[1] = mapData[currentRow][c] - mapData[currentRow][c + 1]; // change forward
            if (currentRow == mapData.length - 1){ // change down
                choices[2] = Integer.MAX_VALUE;
            } else {
                choices[2] = mapData[currentRow][c] - mapData[currentRow + 1][c+1];
            }

            int choice;
            if (choices[1] <= choices[0] && choices[1] <= choices[2]){ // if right is good option
                choice = 1;
            } else if (choices[0] < choices[2]){ // if up is good option
                choice = 0;
            } else if (choices[2] < choices[1]){
                choice = 2;
            } else {
                if (Math.random() < 0.5){
                    choice = 0;
                } else {
                    choice = 2;
                }
            }

            if (choice == 0){
                currentRow--;
            } else if (choice == 2){
                currentRow++;
            }

            sum += choices[choice];

            GRect pixel = new GRect(c, currentRow, 1, 1);
            pixel.setColor(drawColor);
            pixel.setFilled(true);
            graphics.add(pixel);
        }
        return sum;
    }
    
    public double drawLowestDjikstras(GraphicsProgram graphics, int startRow, Color drawColor){
        return 0;
    }
    
    public int getIndexOfLowestElevPath(GraphicsProgram graphics){
        int bestLineIndex = 0;
        double bestLineLength = 0;
        for (int i = 1; i < mapData.length; i++){
            double currentLineLength = drawLowestElevPath(graphics, i, Color.red);
            if (bestLineLength > currentLineLength){
                bestLineIndex = i;
                bestLineLength = currentLineLength;
            }
        }
        return bestLineIndex;
    }
    
    public int getIndexOfLowestDownhillPath(GraphicsProgram graphics){
        int bestLineIndex = 0;
        double bestLineLength = 0;
        for (int i = 1; i < mapData.length; i++){
            double currentLineLength = drawLowestDownhillPath(graphics, i, Color.orange);
            if (bestLineLength > currentLineLength){
                bestLineIndex = i;
                bestLineLength = currentLineLength;
            }
        }
        return bestLineIndex;
    }

    //assess between all three coordinates to the left and pick the one with the least elevation change from your current position, return either 0, 1, or 2 based on the choice

    
}
