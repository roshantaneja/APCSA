import java.awt.Color;

public class Bullet extends GVectorPolygon {
    private int numTurns;
    private static final int MAXTURNS=150;

    public Bullet(int windowWidth, int windowHeight) {
       super(windowWidth, windowHeight);
       numTurns = 0;
       addVertex(-1, 1);
       addVertex(1, 1);
       addVertex(1, -1);
       addVertex(-1, -1);
       recenter();
       setFilled(true);
    }
    // complete this in version 0.5

    public boolean stillMoving() {
        return numTurns < MAXTURNS;
    }
    
    @Override
    public void updatePosition(){
        numTurns ++;
        super.updatePosition();
    }
}
