
import acm.program.*;

public class QuadraticFormula extends ConsoleProgram
{

    public void run()
    {
        double a = readDouble("a: ");
        double b = readDouble("b: ");
        double c = readDouble("c: ");

        System.out.println(calcQuadratic(a, b, c));
    }

    public double[] calcQuadratic(double a, double b, double c){
        return ((-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/2a), ((-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/2a)
    }

}