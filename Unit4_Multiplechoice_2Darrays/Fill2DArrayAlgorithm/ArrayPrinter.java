
import acm.program.*;

public class ArrayPrinter extends ConsoleProgram
{
    private Fill2DArrayAlgorithmNotes algorithm = new Fill2DArrayAlgorithmNotes();
    
    public void run()
    {
        int[][] array = algorithm.getGridOfNumbersUsingCounterStartingAtOne(4, 4);
        for (int[] r: array){
            for (int c: r){
                print(c + " ");
            }
            println();
        }
    }

}
