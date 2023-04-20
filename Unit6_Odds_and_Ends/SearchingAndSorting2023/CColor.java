import java.awt.Color;
import java.util.Random; 

public class CColor extends Color implements Comparable<CColor>
{ 

    public CColor(int r, int g, int b)
    {
        super(r, g, b);
    }

    public int compareTo(CColor other)
    {
        int thisNum = getRed()+getBlue()+getGreen();
        int otherNum = other.getRed()+other.getBlue()+other.getGreen();
        return otherNum-thisNum; // will be negative, zero, or positive
    }
    
}
