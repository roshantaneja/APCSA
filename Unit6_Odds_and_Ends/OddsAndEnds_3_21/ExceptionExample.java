
import acm.program.*;

public class ExceptionExample extends ConsoleProgram
{

    public void run()
    {
        // The code below is a TERRIBLE use of try/catch as it relates to exceptions.
        int[] nums = new int[1000];
        for (int i=0; i<nums.length; i++)
        {
            nums[i] = (int)(Math.random()*1000);
        }

        boolean foundPair = false;
        try 
        {
            for (int i=0; i<nums.length; i++)
            {
                if (nums[i] == nums[i+1])
                    foundPair = true;
            }
        }
        catch (Exception ex)
        {  
            
        }

        if (foundPair)
            println("I found a pair of numbers!");
        else
            println("Sadly, I didn't find a pair of numbers.");

    }
}

/* MOST COMMON EXCEPTIONS
 * 
 * These are RUNTIME errors, since they can't always be caught at compile time!
 * 
 * ArrayIndexOutOfBoundsException
 * ArithmeticException (divide by zero, sqrt of a negative number)
 * ConcurrentModificationException (modifying an ArrayList inside a for each loop)
 * NullPointerException (trying to say x.method() when x is null)
 * IndexOutOfBoundsException (you get this if your bounds to substring don't make sense for a string)
 * ClassCastException (you can't typecast a GRect to a HotelTelevision)
 */

