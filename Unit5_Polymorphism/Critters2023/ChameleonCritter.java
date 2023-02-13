
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class ChameleonCritter extends Critter
{

    public ChameleonCritter()
    {
        super();
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors){
        if (actors.size() > 0){
            int index = (int) (Math.random() * actors.size());
            Actor a = actors.get(index);
            setColor(a.getColor());
        }
    }
    
    @Override
    public void makeMove(Location loc){
        Location current = getLocation();
        int dir = current.getDirectionToward(loc);
        setDirection(dir);
        super.makeMove(loc);
    }

}
