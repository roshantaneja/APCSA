
import acm.program.*;

public class BaseballProgram extends ConsoleProgram
{

    public void run()
    {
        BaseballInning inning = new BaseballInning(4);
        
        println(inning.getCurrentBatter() + " is up at bat");
        
        inning.batterBaseHit(2);
        
        println("---");
        
        println(inning.getBaseRunners());
        println(inning.getCurrentBatter() + " is up at bat");
        
        println("---");
        
        inning.batterOut();
        
        println("---");
        
        println(inning.getBaseRunners());
        println(inning.getCurrentBatter() + " is up at bat");
        
        println("---");
        
        inning.batterBaseHit(3);
        println(inning.getRuns() + " runs");
        println(inning.getBaseRunners());
        println(inning.getCurrentBatter() + " is up at bat");
        
        int outs = inning.getOuts();
        
    }

}
