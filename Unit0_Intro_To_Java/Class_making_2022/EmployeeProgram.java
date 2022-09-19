
import acm.program.*;

public class EmployeeProgram extends ConsoleProgram
{

    public void run()
    {
        Employee person = new Employee("Bruce Wayne", 10900.00);
        person.raiseSalary(250);
        println(person.getName() + " earns " + person.getSalary() + ".");
    }


}
