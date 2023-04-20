
import acm.program.*;

public class RecursionProgram extends ConsoleProgram
{

    public void run()
    {
        int num = factorial(10);
        println(num);
    }
    
    public int factorial(int n){
        if (n < 2){
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
    
    public int factIterative(int n){
        int result = 1;
        for (int i = 1; i <= n; i ++){
            result *= i;
        }
        return result;
    }

}
