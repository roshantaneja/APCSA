
import acm.program.*;

public class RandomConsoleProgram extends ConsoleProgram
{

    public void run()
    {
        while (true)
        {
            // Math.random() --> [0,1)
            int num = (int)(Math.random() * 10) + 1; 
            println(num);
            pause(100);
        }
    }


}
