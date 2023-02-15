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
    }
    
    // finish this up
}
