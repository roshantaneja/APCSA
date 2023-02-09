
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class BoxBug extends Bug
{
    private int length;
    private int steps;
    
    public BoxBug(int sideLength)
    {
        super();
        length = sideLength;
        steps = 0;
    }
    
    @Override
    public void act(){
        if (steps < length){
            super.act();
            steps++;
        } else {
            turn();
            turn();
            steps = 0;
        }
    }

    
}
