
import acm.program.*;

public class Ponies extends ConsoleProgram
{

    public void run()
    {
        println("I Like Ponies");
        for (int i=0; i<10; i++) {
            println("They are cute");
        }
        int numPonies = 6;
        //i have 6 ponies
        numPonies = readInt("How many ponies? ");
        // now i have some arbitrary number of ponies
        println("you have " + numPonies + " ponies.");
        int numLegs;
        numLegs = numPonies * 4;
        println("your ponies have " + numLegs + " legs.");
        if (numLegs > 100){
            println("wow!, thats a lot of legs!");
        }
    }

}
