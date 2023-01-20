

public class Fill2DArrayAlgorithmNotes
{
    public int[][] getGridOfNumbersUsingCounterStartingAtOne(int rows, int cols)
    {
       int[][] result = new int[rows][cols];
       int counter = 1;
       for (int r = 0; r < rows; r++){
           for (int c = 0; c < cols; c++){
               result[r][c] = counter;
               counter ++;
           }
       }
       return result;
    }
    
    public int[][] getGridOfNumbersUsingCounter(int rows, int cols)
    {
       int[][] result = new int[rows][cols];
       int counter = 0;
       for (int r = 0; r < rows; r++){
           for (int c = 0; c < cols; c++){
               result[r][c] = counter;
               counter ++;
           }
       }
       return result;
    }

    public int[][] getGridOfNumbersUsingMath(int rows, int cols)
    {
       int[][] result = new int[rows][cols];
       for (int r = 0; r < rows; r++){
           for (int c = 0; c < cols; c++){
               result[r][c] = r * cols + c;
           }
       }
       return result;
    }
    
    public int[][] getGridOfNumbersUsingMathColumnMajorOrder(int rows, int cols)
    {
       int[][] result = new int[rows][cols];
       for (int c = 0; c < cols; c++){
           for (int r = 0; r < rows; r++){
               result[r][c] = c * rows + r;
           }
       }
       return result;
    }
    
    public String[][] getGridOfWordsUsingMath (int rows, int cols, String[] words)
    {
       String[][] result = new String[rows][cols];
       int counter = 0;
       for (int r = 0; r < rows; r++){
           for (int c = 0; c < cols; c++){
               result[r][c] = words[counter];
               counter++;
           }
       }
       return result;
    }
    
    public String[][] getGridOfWordsUsingMathIfPresent (int rows, int cols, String[] words)
    {
       String[][] result = new String[rows][cols];
       for (int r = 0; r < rows; r++){
           for (int c = 0; c < cols; c++){
               int index = r * cols + c;
               if (index > words.length){
                   result[r][c] = words[index];
               }
           }
       }
       return result;
    }
    
    public String[][] getGridOfWordsColumnMajorUsingMathIfPresent (int rows, int cols, String[] words)
    {
       String[][] result = new String[rows][cols];
       for (int c = 0; c < cols; c++){
           for (int r = 0; r < rows; r++){
               int index = c * rows + r;
               if (index > words.length){
                   result[r][c] = words[index];
               }
           }
       }
       return result;
    }
}
