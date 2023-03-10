import java.awt.Color;

public class Ship extends GVectorPolygon
{

    public Ship(int windowWidth, int windowHeight)
    {
        // write this in version 0.4
        super(windowWidth, windowHeight);
        addVertex(-3, 0);
        addVertex(-10, 10);
        addVertex(10, 0);
        addVertex(-10, -10);
        rotate(90);
        scale(1.5);
        recenter();
    }

    // you'll add a method here in version 0.5.1

}
