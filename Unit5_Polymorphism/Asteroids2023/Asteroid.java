import acm.graphics.*;
import java.awt.Color;
import java.util.*;

public class Asteroid extends GVectorPolygon
{
    private double rotation;

    public Asteroid(int windowWidth, int windowHeight)
    {
       super(windowWidth, windowHeight);
       rotation = Math.random();
       addVertex(25, -45);
       addVertex(-25, -45);
       addVertex(-50, 0);
       addVertex(-25, 45);
       addVertex(25, 45);
       addVertex(50, 0);
       recenter();
    }
    
    @Override
    public void updatePosition(){
        rotate(rotation);
        super.updatePosition();
    }
}
