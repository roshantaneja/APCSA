
import acm.program.*;

public class DogProgram extends ConsoleProgram
{

    public void run()
    {
        Dog katesDog = new Dog("lily");
        Dog trentsDog = new Dog("dante");
        Dog vishnusDog = new Dog("calvin");
        
        println(trentsDog.getID());
        println(Dog.isHappyToSeeYou());
    }

}
