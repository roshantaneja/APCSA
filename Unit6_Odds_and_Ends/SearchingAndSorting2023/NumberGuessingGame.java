
import acm.program.*;

public class NumberGuessingGame extends ConsoleProgram
{

    public void run()
    {
        setFont("*-*-24");  // set the font size to 24 point
        
        int secretNumber = (int)(Math.random() * 100 + 1);
        
        println("I'm thinking of a number between 1 and 100, inclusive.");
        int guess = readInt("What's your guess? ");
        int numGuesses = 1;

        while (secretNumber != guess)
        {
            if (guess < secretNumber)
                println("Too low.  Guess again.");
            else // otherwise, it's too big
                println("Too high.  Guess again.");
            guess = readInt("What's your guess? ");
            numGuesses++;
        }
        println("You got it!");
        println("It took you " + numGuesses + " guesses.");
    }


}
