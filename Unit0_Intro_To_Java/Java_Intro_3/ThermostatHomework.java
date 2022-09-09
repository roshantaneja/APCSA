
import acm.program.*;

public class ThermostatHomework extends ConsoleProgram
{

    public void run()
    {
        int min = readInt("What do want the min to be? ");
        Thermostat therm  = new Thermostat(min, 80);

        for (int i=0; i<10; i++)
        {
            therm.colder();
        }
    }

}
