import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ColorComparer extends Frame implements Runnable
{

    private static final int REFRESH_RATE = 50;  //Constant for "delay"
    private static final int WIDTH = 900;
    private static final int HEIGHT = 200;
    private Graphics offscreen;
    private Image image;
    private Thread animation;  //declares a thread called animation
    private ArrayList<CColor> colors;

    public ColorComparer(int width, int height)
    { 
        setTitle("Color Comparer");
        setLayout(new FlowLayout());
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });
        requestFocus();

        setSize(width, height);
        setVisible(true);

        image = createImage(width, height);
        offscreen = image.getGraphics();

        //init code here
        colors = new ArrayList<CColor>();
        int grayScaleValue;
        /*for (int k=0; k < getWidth(); k++)
            colors.add(new CColor((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
        */
        for (int k=0; k < getWidth(); k++){
            grayScaleValue = (int)(Math.random()*256);
            colors.add(new CColor(grayScaleValue, grayScaleValue, grayScaleValue));
        }
       
    }

    public static void main(String args[]) 
    {
        ColorComparer app = new ColorComparer(WIDTH, HEIGHT);
        app.start();
    }

    public void paint(Graphics g)
    {
        if (offscreen == null)
            return;
        offscreen.fillRect(0,0,WIDTH,HEIGHT);

        // draw code here
        for (int k=0; k < colors.size(); k++)
        {
            offscreen.setColor((Color)colors.get(k));
            offscreen.drawLine(k, 0, k, getHeight());
        }

        g.drawImage(image, 0, 0, this);
    }

    public void start()
    {
        animation = new Thread(this);
        if(animation != null)
        {
            animation.start();
        }
    }

    public void run()
    {    
       bubbleSort(colors);
    }

    public void drawAndWait()
    {
        repaint();
        try
        {
            Thread.sleep(REFRESH_RATE);
        }catch(Exception exc){};

    }

    public void stop() 
    {
        animation = null;
    }

    public void keyPressed (KeyEvent ke)  
    {
    }

    public void keyReleased (KeyEvent ke)      
    {
    }

    public void keyTyped (KeyEvent ke)
    {
    }

    public void bubbleSort(ArrayList<CColor> list)
    {
        int j,k;
        CColor temp;
        for(j=list.size()-1; j > 0; j--)
        {
            drawAndWait();
            // find largest element in 0..k, move to A[j]
            for(k=0; k < j; k++)
            {
                if (list.get(k+1).compareTo(list.get(k))<0)
                {
                    temp = list.get(k);
                    list.set(k, list.get(k+1));
                    list.set(k+1, temp);

                }
            }   
        }
    }

    public void selectionSort(ArrayList<CColor> list )
    {
        int j,k,min;
        CColor temp;

        for(j=0; j< list.size()-1;j++)
        {
            min = j;
            for(k=j+1; k<list.size(); k++)
            {
                if (list.get(k).compareTo(list.get(min))<0)
                { min = k;}
            }
            temp = list.get(min);
            list.set(min, list.get(j));
            list.set(j, temp);
            drawAndWait();
        }    
    }

    public void insertionSort(ArrayList<CColor> list)
    {
        int k,loc;

        for(k=1;k<=list.size();k++) 
        {
            // shift elements to make room for A[k]
            CColor hold = list.get(k);   // insert this element
            loc = k;            // location for insertion
            while ((0 < loc)  && (hold.compareTo(list.get(loc-1))<0))
            {
                list.set(loc,list.get(loc-1));
                loc--;
            }
            list.set(loc,hold);
            drawAndWait();
        }
    }
}

