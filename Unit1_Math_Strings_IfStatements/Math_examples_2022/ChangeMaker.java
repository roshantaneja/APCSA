
import acm.program.ConsoleProgram;

public class ChangeMaker extends ConsoleProgram {
    public ChangeMaker() {
    }

    public void run() {
        double cost = 110;//readDouble("Enter cost of the item: ");
        double paid = 134.34;//readDouble("Enter the amount paid: ");
        if (paid < cost) {
            println("you owe more money")
        } else {
            int change = (int) ((paid - cost) * 100.0);
            int dollars = change / 100;
            change %= 100;
            int quarters = change / 25;
            change %= 25;
            int dimes = change / 10;
            change %= 10;
            int nickels = change / 5;
            int pennies = change % 5;
            println("Your change is "
                    + dollars + " dollars, "
                    + quarters + " quarters, "
                    + dimes + " dimes, "
                    + nickels + " nickels, and "
                    + pennies + " pennies.");
        }
    }
}