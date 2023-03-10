import acm.graphics.*;
import java.awt.Color;
import java.util.*;

public class Asteroid extends GVectorPolygon
{
    private double rotation;

    public Asteroid(int windowWidth, int windowHeight)
    {
       // write this in version 0.2
       super(windowWidth, windowHeight);
       rotation = Math.random();
       addVertex(5, -9);
       addVertex(-5, -9);
       addVertex(-10, 0);
       addVertex(-5, 9);
       addVertex(5, 9);
       addVertex(10, 0);
       scale(5);
       rotate(Math.random()*180 - 90);
       recenter();
    }
    
    @Override
    public void updatePosition(){
        rotate(rotation);
        super.updatePosition();
    }

    // complete this in version 0.2
}
