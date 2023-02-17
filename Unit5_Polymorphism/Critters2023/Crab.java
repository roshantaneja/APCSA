
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
    
    @Override
    public void makeMove(Location loc){
        Location current = getLocation();
        if (current.equals(loc)){
            int dir = getDirection();
            if (Math.random() < 0.5){
                setDirection(dir + Location.RIGHT);
            } else {
                setDirection(dir + Location.LEFT);
            }
        } else {
            super.makeMove(loc);
        }
        
    }
    
    @Override
    public ArrayList<Actor> getActors(){
        ArrayList<Actor> result = new ArrayList<Actor>();
        Location current = getLocation();
        int dir = getDirection();
        Grid<Actor> gr = getGrid();
        
        Location ahead = current.getAdjacentLocation(dir);
        
        if (gr.isValid(ahead) && gr.get(ahead) != null){
            result.add(gr.get(ahead));
        }
        
        Location left = current.getAdjacentLocation(dir + Location.HALF_LEFT);
        
        if (gr.isValid(left) && gr.get(left) != null){
            result.add(gr.get(left));
        }
        
        Location right = current.getAdjacentLocation(dir + Location.HALF_RIGHT);
        
        if (gr.isValid(right) && gr.get(right) != null){
            result.add(gr.get(right));
        }
        
        return result;
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors){
        if (actors.size() > 0){
            int index = (int)(Math.random() * actors.size());
            Actor a = actors.get(index);
            if (! (a instanceof Rock) && !(a instanceof Critter)){
                a.removeSelfFromGrid();
            }
        }
    }

}
