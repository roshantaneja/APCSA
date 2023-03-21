
import acm.program.*;

public class NumberProgram extends ConsoleProgram
{

    public void run()
    {
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < 20; i++){
            num++;
            println(num);
        }
    }

}
