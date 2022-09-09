
import acm.program.*;

public class BaseballProgram extends ConsoleProgram
{

    public void run()
    {
        BaseballInning inning;
        inning = new BaseballInning(4);
        println("The current batter is " + inning.getCurrentBatter());
        inning.batterBaseHit(2);
        
        println(inning.getBaseRunners());
        println("The current batter is " + inning.getCurrentBatter());
        
        inning.batterOut();
        
        println(inning.getBaseRunners());
        println("The current batter is " + inning.getCurrentBatter());
        
        inning.batterBaseHit(3);
        
        println("The Giants now have " + inning.getRuns() + "run!");
        
        int outs = inning.getOuts();
        outs = outs * 7;
        println(outs);

    }

}
