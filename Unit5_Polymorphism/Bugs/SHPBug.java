import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.world.*;
import java.awt.Color;

public class SHPBug extends Bug
{

    public SHPBug()
    {
        super();
        setColor(Color.red);
    }
    
    @Override
    public void setColor(Color color){
        super.setColor(Color.red);
    }
    
    @Override
    public void act(){
        if (getColor().equals(Color.white)){
            super.setColor(Color.red);
        } else {
            super.setColor(Color.white);
        }
        super.act();
    }

}
