import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.world.*;

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
            return; // leaves before getting pregnant again
            //doesnt process anymore actors
        }
        for (Actor a : actors){
            if (a instanceof MaleFish){
                MaleFish f = (MaleFish)(a);
                if (f.getAge() >= BREEDAGE && getAge() >= BREEDAGE && turnsPregnant == 0){
                    turnsPregnant = 1;
                    setColor(Color.RED);
                }
            }
        }
    }
    
    @Override
    public void act(){
        if (getGrid() == null){
            return;
        }
        
        if (turnsPregnant > 0){
            turnsPregnant += 1;
        }
        if (turnsPregnant >= 5){
            giveBirth();
        }
        super.act();
    }
    
    public void giveBirth(){
        Location current = getLocation();
        Grid<Actor> gr = getGrid();
        
        ArrayList<Location> emptyLocations = gr.getEmptyAdjacentLocations(current);
        
        if (emptyLocations.size() > 0){
            int gender = (int) (Math.random()* 2);
            Location birthPlace = emptyLocations.get((int)(Math.random() * emptyLocations.size()));
            
            Fish fish;
            if (gender == 0){
                fish = new MaleFish();
            } else {
                fish = new FemaleFish();
            }
            fish.putSelfInGrid(gr, birthPlace);
            turnsPregnant = 0;
        }
    }
    
    // finish this up
}
