
import acm.program.*;

public class ThermostatHomework extends ConsoleProgram
{

    public void run()
    {
        int min = readInt("What do want the min to be? ");
        Thermostat therm  = new Thermostat(min, 80);
        
        println("the temperature is now " + therm.getValue());
        
        while (true){
            String increment = readLine("w (Warmer) or c (Colder)? ");
            if (increment == "w"){
                therm.warmer();
            } else if (increment == "c") {
                therm.colder();
            }
            println("the temperature is now " + therm.getValue());
        }
    }

}
