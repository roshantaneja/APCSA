
import acm.program.*;

public class CarProgram extends ConsoleProgram
{

    public void run()
    {
        println("Hello cars!");
        int x = 7;
        String name = "Marty";
        
        Car prius = new Car(50, 9);
        prius.fillup(7);
        prius.drive(55);
        
        println("Hello");
        println(prius.getOdometer());
        int num = prius.getGasGauge();
        prius.drive(100);
        println(num);
        println(prius.getGasGauge());
        if (prius.getGasGauge() < 10)
        {
            println("You should get gas.");
        }
    }

}
