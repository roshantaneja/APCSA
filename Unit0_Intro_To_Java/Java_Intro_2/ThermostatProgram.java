// Roshan Taneja
import acm.program.*;

public class ThermostatProgram extends ConsoleProgram
{

    public void run()
    {
        Thermostat therm = new Thermostat(60, 120);
        
        println("the temperature is " + therm.getValue());
        
        int reduce = readInt("how much do you want to reduce the temperature? ");
        
        for (int i = 0; i<reduce; i++){
            therm.colder();
            println("the temperature is " + therm.getValue());
            pause(15);
        }
        
        //println("the temperature is " + therm.getValue());
    }

}
