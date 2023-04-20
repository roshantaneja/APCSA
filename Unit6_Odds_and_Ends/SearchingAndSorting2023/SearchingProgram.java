
import acm.program.*;
import java.util.Arrays;

public class SearchingProgram extends ConsoleProgram
{
    private static final int MAX = 1000000;
    private static final int VALUE = 27;

    public void run()
    {
        setFont("*-*-24");

        int[] nums = getRandomArray(2000000);

        long startTime = System.currentTimeMillis();
        boolean result = linearSearch(nums, VALUE);
        long stopTime = System.currentTimeMillis();

        if (result)
            println("Value found");
        else
            println("Value not found");
        println("Elapsed time for linear search: " + (stopTime - startTime) + " milliseconds.");

        Arrays.sort(nums);  // we'll talk about how this works later!

        startTime = System.currentTimeMillis();
        result = binarySearch(nums, VALUE);
        stopTime = System.currentTimeMillis();

        if (result)
            println("Value found");
        else
            println("Value not found");
        println("Elapsed time for binary search: " + (stopTime - startTime) + " milliseconds.");

        startTime = System.currentTimeMillis();
        result = binarySearch(nums, VALUE);
        stopTime = System.currentTimeMillis();
    }

    private int[] getRandomArray(int len)
    {
        int[] temp = new int[len];
        for (int i=0; i<len; i++)
            temp[i] = (int)(Math.random()*MAX);
        return temp;
    }

    private boolean linearSearch(int[] nums, int value)
    {
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == VALUE){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int value)
    {
        int lowIndex = 0;
        int highIndex = nums.length -1;
        while (lowIndex <= highIndex){
            int midIndex = (lowIndex + highIndex) / 2;
            if (nums[midIndex] == VALUE){
                return true;
            } else if (nums[midIndex] < VALUE){
                lowIndex = midIndex + 1;
            } else {
                highIndex = midIndex -1;
            }
        }
        return false;
    }

}
