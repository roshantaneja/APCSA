
import acm.program.*;

public class CelebrityGame extends ConsoleProgram
{

    public void run()
    {
        String name = readLine("what is the celebrities name?");

        for (int i = 0; i < 100; i++){
            println();
        }
        String firstName = name.substring(0, name.indexOf(" "));
        String lastName = name.substring(name.indexOf(" ") + 1);

        println("hint: " + firstName.substring(firstName.length() - 2) + " " + lastName.substring(0, 3));

        String guess = readLine("what is your guess?: ");

        if (guess.toLowerCase().equals(name.toLowerCase())) { // added case sensitive answers to return true
            println("youre correct!");
        } else {
            println("nope! the answer was " + name);
        }
    }

}
