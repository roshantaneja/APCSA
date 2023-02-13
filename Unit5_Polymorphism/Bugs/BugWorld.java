
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;

public class BugWorld
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        //world.add(new Bug());
        //world.add(new Rock());
        //world.add(new LeftBug());
        //world.add(new SHPBug());
        //world.add(new BoxBug(7));
        world.add(new SpiralBug(10));
        world.show();
    }
}
