import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;

public class LeftBug extends Bug
{

    public LeftBug()
    {
        super();
        setColor(Color.green);
    }
    
    @Override
    public void turn(){
        setDirection(getDirection() - Location.HALF_RIGHT);
    }

}
