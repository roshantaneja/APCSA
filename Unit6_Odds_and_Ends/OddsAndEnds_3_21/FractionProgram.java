
import acm.program.*;

public class FractionProgram extends ConsoleProgram
{
    public void run()
    {
        Fraction a = new Fraction(3, 8);
        Fraction b = new Fraction(5, 6);
        Fraction c = a.add(b);
        Fraction d = new Fraction(7);
        Fraction e = d.reciprocal();
        Fraction f = a.multiply(b);
        Fraction g = a.divide(b);
        Fraction h = b.cubed();
        println("a = " + a.toString());
        println("b = " + b.toString());
        println("c = " + c.toString());
        println("d = " + d.toString());
        println("e = " + e.toString());
        println("f = " + f.toString());
        // I left off the .toString for g and h just because, why not?
        println("g = " + g);
        println("h = " + h);
    }
}
