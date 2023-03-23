
import acm.program.*;

public class ComplexProgram extends ConsoleProgram
{ 

    public void run()
    {
        ComplexNumber first = new ComplexNumber(3, 4);
        ComplexNumber second = new ComplexNumber(7, -2);
        ComplexNumber third = first.add(second);
        ComplexNumber fourth = first.multiply(second);
        ComplexNumber fifth = first.squared();
        println(first);
        println(second.toString());
        println(third.toString());
        println(fourth.toString());
        println(fifth.toString());
    }

}
