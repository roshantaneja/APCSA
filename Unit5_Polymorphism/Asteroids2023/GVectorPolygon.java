import acm.graphics.*;

public class GVectorPolygon extends GPolygon
{
    private double vx, vy;
    private double theta;
    private double maxX, maxY; // dimensions of the "window" to enable "wrapping around"

    private static final double MAXVELOCITY = 3;

    public GVectorPolygon(int windowWidth, int windowHeight)
    {
       // to be written in version 0.1
       super();
       vx = 0;
       vy = 0;
       theta = 0;
       maxX = windowWidth;
       maxY = windowHeight;
    }

    public void increaseVelocity(double numPixels)
    {
       // to be written in version 0.1
       double thetaInRadians = theta * Math.PI / 180;
       vx += Math.cos(thetaInRadians) * numPixels;
       vy += -Math.sin(thetaInRadians) * numPixels;
    }

    public void updatePosition()
    {
        // to be written in version 0.1
        move(vx, vy);
        if(getX() < 0){
            setLocation(maxX, getY());
        }
        if(getX() > maxX){
            setLocation(0, getY());
        }
        if(getY() < 0){
            setLocation(getX(), maxY);
        }
        if(getY() > maxY ){
            setLocation(getX(), 0);
        }
    }

    @Override
    public void rotate(double angle)
    {
        // to be written in version 0.1
        theta += angle;
        super.rotate(angle);
    }

    public double getTheta()
    {
        return theta;
    }

    public double getVelocityX()
    {
        return vx;
    }

    public double getVelocityY()
    {
        return vy;
    }

    public double getWindowWidth()
    {
        return maxX;
    }
    
    public double getWindowHeight()
    {
        return maxY;
    }
}
