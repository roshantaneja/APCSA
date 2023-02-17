
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class GridWorldProgram
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Bug());
        world.add(new Rock());
        world.add(new ChameleonCritter());
        world.add(new Crab());
        world.show();
    }
}
