
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class Crab extends Critter
{

    public Crab()
    {
        super();
        setColor(Color.orange);
    }
    
    @Override
    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> result = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location current = getLocation();
        int dir = getDirection();
        Location right = current.getAdjacentLocation(dir + Location.RIGHT);
        if (gr.isValid(right) && gr.get(right) == null){
            result.add(right);
        }
        
        Location left = current.getAdjacentLocation(dir + Location.LEFT);
        if (gr.isValid(left) && gr.get(left) == null){
            result.add(left);
        }
        
        return result;
    }

}
