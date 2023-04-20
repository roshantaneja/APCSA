import java.util.*;
import java.io.*;

public class FileHelper
{
    /** Reads double data from a file.  
     * @param filename the name of the file to be read, which should be in the project folder
     * @param desiredArrayLength the desired length of the returned array, which should be the number of doubles in the entire file
     * @return an array consisting of all the doubles in the file, which should be desiredArrayLength long; if there is a issue reading from the file, or the file does not contain exactly desiredArrayLength doubles, then this method returns an empty array (length = 0)
     */
    public static double[] readDataFromFile(String filename, int desiredArrayLength)
    {
        double[] empty = new double[0];
        int count = 0;
        double[] result = new double[desiredArrayLength];
        try
        {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextDouble())
            {
                double num = scanner.nextDouble();
                result[count] = num;
                count++;
            }
        }
        catch(Exception ex) 
        {
            return empty;
        }
        if (count == result.length)
            return result;
        else
            return empty;
    }

}
