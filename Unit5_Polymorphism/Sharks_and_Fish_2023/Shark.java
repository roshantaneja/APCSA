
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class Shark extends Critter
{
    // constants
    private static final int MUSTEAT = 8;

    // private instance variables
    private int turnsSinceEaten;
    
    public Shark()
    {
        super();
        setColor(Color.black);
        turnsSinceEaten = 0;
    }
    
    @Override
    public void act(){
        if (getGrid() == null){
            return;
        }
        
        super.act();
    }
    
    @Override
    public void processActors(ArrayList<Actor> actors){
        if (actors.size() == 0){
            turnsSinceEaten++;
        } else {
            ArrayList<Fish> fishList = new ArrayList<Fish>();
            for (Actor a : actors){
                if (a instanceof Fish && !(a instanceof Shark)){
                    fishList.add((Fish)(a));
                }
            }
            
            if (fishList.size() > 0){
                int index = (int)(Math.random() * fishList.size());
                Fish eatenFish = fishList.get(index);
                eatenFish.removeSelfFromGrid();
                turnsSinceEaten = 0;
            } else {
                turnsSinceEaten ++;
            }
        }
        if (turnsSinceEaten >= MUSTEAT){
            removeSelfFromGrid();
        } 
    }
    
    @Override
    public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> result = new ArrayList<Location>();
        Grid<Actor> gr = getGrid();
        Location current = getLocation();
        int dir = getDirection();
        
        Location halfRight = current.getAdjacentLocation(dir + Location.HALF_RIGHT);
        if (gr.isValid(halfRight) && gr.get(halfRight) == null){
            result.add(halfRight);
        }
        
        Location halfLeft = current.getAdjacentLocation(dir + Location.HALF_LEFT);
        if (gr.isValid(halfLeft) && gr.get(halfLeft) == null){
            result.add(halfLeft);
        }
        
        Location ahead = current.getAdjacentLocation(dir + Location.AHEAD);
        if (gr.isValid(ahead) && gr.get(ahead) == null){
            result.add(ahead);
        }
        
        return result;
        
    }
    
    @Override
    public void makeMove(Location loc){
        Location current = getLocation();
        int dir = current.getDirectionToward(loc);
        setDirection(dir);
        
        if (current.equals(loc)){
            int myDir = getDirection();
            if (Math.random() > 0.5){
                setDirection(myDir + Location.HALF_RIGHT);
            } else {
                setDirection(myDir + Location.HALF_LEFT);
            }
        } else {
            super.makeMove(loc);
        }
    }
    
    // finish this up

}
