import acm.program.*;

public class Hangman extends ConsoleProgram{
    private static String word = RandomWordGenerator.getRandomWord();
    private static String asterisk = new String(new char[word.length()]).replace("\0", "*");
    
    int lives = 7;

    public void run() {
        //Scanner sc = new Scanner(System.in);
        
        while (lives > 0 && asterisk.contains("*")) {
            println();
            println(asterisk);
            String guess = readLine("Guess any letter in the word").toUpperCase();
            hang(guess);
        }
        //sc.close();
    }

    public void hang(String guess) {
        String newasterisk = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess.charAt(0)) {
                newasterisk += guess.charAt(0);
            } else if (asterisk.charAt(i) != '*') {
                newasterisk += word.charAt(i);
            } else {
                newasterisk += "*";
            }
        }

        if (asterisk.equals(newasterisk)) {
            lives--;
            hangmanImage();
        } else {
            asterisk = newasterisk;
        }
        if (asterisk.equals(word)) {
            println("Correct! You win! The word was " + word);
        }
    }

    public void hangmanImage() {
        if (lives == 6) {
            println("Wrong guess, try again");
            println();
            println();
            println();
            println();
            println();
            println("___|___");
        }
        if (lives == 5) {
            println("Wrong guess, try again");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("___|___");
        }
        if (lives == 4) {
            println("Wrong guess, try again");
            println("   ____________");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("   |");
            println("   | ");
            println("___|___");
        }
        if (lives == 3) {
            println("Wrong guess, try again");
            println("   ____________");
            println("   |          _|_");
            println("   |         /   \\");
            println("   |        |     |");
            println("   |         \\_ _/");
            println("   |");
            println("   |");
            println("   |");
            println("___|___");
        }
        if (lives == 2) {
            println("Wrong guess, try again");
            println("   ____________");
            println("   |          _|_");
            println("   |         /   \\");
            println("   |        |     |");
            println("   |         \\_ _/");
            println("   |           |");
            println("   |           |");
            println("   |");
            println("___|___");
        }
        if (lives == 1) {
            println("Wrong guess, try again");
            println("   ____________");
            println("   |          _|_");
            println("   |         /   \\");
            println("   |        |     |");
            println("   |         \\_ _/");
            println("   |           |");
            println("   |           |");
            println("   |          / \\ ");
            println("___|___      /   \\");
        }
        if (lives == 0) {
            println("GAME OVER!");
            println("   ____________");
            println("   |          _|_");
            println("   |         /   \\");
            println("   |        |     |");
            println("   |         \\_ _/");
            println("   |          _|_");
            println("   |         / | \\");
            println("   |          / \\ ");
            println("___|___      /   \\");
            println("GAME OVER! The word was " + word);
        }
    }
}