
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        String name;
        name = readLine("What is your name? ");
        println("Have a nice day, " + name + "!");
        println("I like ponies.");
        for (int i=0; i<10; i++)
        {
            println("They are cute.");
        }
        int numPonies;
        numPonies = readInt("How many ponies? ");
        println("You have " + numPonies + " ponies.");
        int numLegs;
        numLegs = numPonies * 4;
        println("You have " + numLegs + " pony legs.");
        if (numLegs > 100)
        {
            println("Wow!  That's a lot of legs!");
        }
        
        int x = 4;
        String y = "What a nice flag";
        double z = 2.75;
        
        int bob = 2;
        String lucy = "Hello";
        double emma = 0.06;
        
        bob = x;
        x = 7;
        x = x + 1;
        
    }

}
