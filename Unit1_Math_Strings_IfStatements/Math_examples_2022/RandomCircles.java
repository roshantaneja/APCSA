
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class RandomCircles extends GraphicsProgram {
    public void run() {
        int numCircles = (int) (Math.random() * 500.0) + 100;

        for (int i = 0; i < numCircles; ++i) {
            int diam = (int) (Math.random() * 200.0) + 50;
            int x = (int) (Math.random() * (double) getWidth() - diam);
            int y = (int) (Math.random() * (double) getHeight() - diam);
            GOval circle = new GOval((double) x, (double) y, (double) diam, (double) diam);
            circle.setFilled(true);
            int red = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            int alpha = (int) (Math.random() * 256);
            Color randomColor = new Color(red, green, blue, alpha);
            circle.setColor(randomColor);
            add(circle);
            pause(20);
        }
    }
}