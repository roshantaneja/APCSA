
import acm.program.*;

public class CarProgram extends ConsoleProgram
{

    public void run()
    {
        println("Hello Cars!");
        int x = 7;
        String name = "marty";
        Car prius;
        prius = new Car(50, 9);
        prius.fillup(50.0);
        prius.drive(55);
        println("Hello");
        println(prius.getOdometer());
        int num = prius.getGasGauge();
        println(num);
    }

}
