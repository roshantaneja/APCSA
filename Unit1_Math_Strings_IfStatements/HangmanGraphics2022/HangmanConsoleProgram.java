
import acm.program.*; 

public class HangmanConsoleProgram extends ConsoleProgram
{

    public void run()
    {
        println("Welcome to Hangman!");
        HangmanGame game = new HangmanGame();
        println(game.getPuzzle());
        println(game.getGuessesLeft() + " guesses left.");
        boolean gameOver = false;

        while (gameOver == false)
        {
            String guess = readLine("Enter a letter: ");
            if (game.makeGuess(guess) == true)
                println("Good guess!");
            else
                println("Bad guess!");

            println(game.getPuzzle());
            println(game.getGuessesLeft() + " guesses left.");
            println("Letters guessed: " + game.getLettersGuessed());  
            if (game.getGuessesLeft() == 0)
                gameOver = true;
            if (game.getPuzzle().equals(game.getActualAnswer()))
                gameOver = true;
        }
        if (game.getGuessesLeft() == 0)
        {
            println("You lost!");
            println("The actual correct answer was " + game.getActualAnswer());
        }
        else
        {
            println("You win!");
        }
    }

}
