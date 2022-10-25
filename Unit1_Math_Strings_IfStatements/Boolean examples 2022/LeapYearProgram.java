
import acm.program.*;

public class LeapYearProgram extends ConsoleProgram
{

    public void run()
    {
        int year = readInt("enter a year: ");
        while (year > 0) {
            if (isLeapYear(year)){
                println("this is a leap year!");
            } else {
                println("that is not a leap year");
            }
            year = readInt("enter a year: ");
        }
        println("goodbye");
    }
    
    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

}
