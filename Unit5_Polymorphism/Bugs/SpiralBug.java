import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;

public class SpiralBug extends BoxBug //makes a spiral and does nothing else
{
    // use an unbounded grid for a larger spiral
    
    public SpiralBug(int sideLength)
    {
        super(sideLength);
    }
    
    @Override
    public void act(){
        if (getSteps() < getLength()){ // both methods in BoxBug
            super.act();
            incrementSteps(); // written in BoxBug
        } else {
            turn();
            turn();
            resetSteps(); // Written in BoxBug
            reduceLength(); // Written in BoxBug
        }
    }
}
