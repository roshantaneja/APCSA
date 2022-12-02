
import acm.program.*;

public class Example extends ConsoleProgram
{
    public void run()
    {
        int[][] nums = new int[10][12];
        
        for (int r = 0; r<nums.length;r++){
            for (int c = 0; c < nums[r].length; c++){
                nums[r][c] = (int)(Math.random()*25);
            }
        }
        
        nums[0][0] = 3;
        nums[0][11] = 3;
        nums[9][0] = 3;
        nums[9][11] = 3;
        
        int counter = 0;
        for (int r = 0; r<nums.length;r++){
            for (int c = 0; c < nums[r].length; c++){
                if (nums[r][c] == 3){
                    counter++;
                }
                if (nums[r][c] / 10 == 0){
                    print(nums[r][c] + "  ");
                }else {
                    print(nums[r][c] + " ");
                }
            }
            println();
        }
        
        println();
        println(counter);
        
    }
}
