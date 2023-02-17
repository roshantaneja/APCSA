import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

public class FemaleFish extends Fish
{
    // constants
    private final static int GESTATIONPERIOD = 5;
    
    // private instance variables
    private int turnsPregnant;
    
    public FemaleFish()
    {
        super();  // needed to call Fish constructor, which initializes age
        setColor(Color.PINK);
        turnsPregnant = 0;
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors){
        if (turnsPregnant > 0) {
            return;
        }
        for (Actor a : actors){
            if (a instanceof MaleFish && getAge() >= BREEDAGE && turnsPregnant == 0){
                turnsPregnant = 1;
                setColor(Color.RED);
            }
        }
    }
    
    // finish this up
}
