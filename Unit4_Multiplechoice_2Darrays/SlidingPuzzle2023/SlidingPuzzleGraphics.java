
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;

public class SlidingPuzzleGraphics extends GraphicsProgram
{
    private static final int GAMESIZE = 4;
    private static final int WINDOWSIZE = 500;
    private static final int EXTRAHEIGHT = 10;

    private SlidingPuzzle game;
    private GLabel[][] labels;
    public void run()
    {
        setSize(WINDOWSIZE, WINDOWSIZE+EXTRAHEIGHT);
        game = new SlidingPuzzle(GAMESIZE);
        drawGrid();
        initializeLabels();
        updateLabelValuesAndPositions();
        addMouseListeners();
        while (!game.isDone())
        {

        }
        GLabel win = new GLabel("Woo hoo!");
        win.setColor(Color.green);
        win.setFont("Arial-Bold-96");
        win.setLocation(WINDOWSIZE/2-win.getWidth()/2,WINDOWSIZE/2+win.getHeight()/2);
        add(win);

    }

    private void drawGrid()
    {
        int tileSize = WINDOWSIZE/GAMESIZE;
        for (int y=0; y<WINDOWSIZE; y+=tileSize)
        {
            GLine line = new GLine(0, y, WINDOWSIZE, y);
            add(line);
        }
        for (int x=0; x<WINDOWSIZE; x+=tileSize)
        {
            GLine line = new GLine(x, 0, x, WINDOWSIZE);
            add(line);
        }
    }

    private void initializeLabels()
    {
        labels = new GLabel[GAMESIZE][GAMESIZE];
        for (int r=0; r<GAMESIZE; r++)
        {
            for (int c=0; c<GAMESIZE; c++)
            {
                labels[r][c] = new GLabel("");
                add(labels[r][c]);
            }
        }
    }

    public void updateLabelValuesAndPositions()
    {
        int tileSize = WINDOWSIZE/GAMESIZE;
        for (int r=0; r<GAMESIZE; r++)
        {
            for (int c=0; c<GAMESIZE; c++)
            {
                labels[r][c].setLabel("" + game.getValueAt(r, c));
                if (game.getValueAt(r, c)==0)
                    labels[r][c].setLabel(" ");
                int fontSize = 72;
                labels[r][c].setFont("Courier-Bold-"+fontSize);
                while (labels[r][c].getWidth() >  tileSize || labels[r][c].getHeight() > tileSize)
                {
                    fontSize--;
                    labels[r][c].setFont("*-*-"+fontSize);
                }
                double x = tileSize*c + tileSize/2 - labels[r][c].getWidth()/2;
                double y = tileSize*r  + tileSize/2 + labels[r][c].getHeight()/2 - tileSize/5;
                labels[r][c].setLocation(x, y);
            }
        }
    }

    public void mouseClicked(MouseEvent event)
    {
        int tileSize = WINDOWSIZE/GAMESIZE;
        int row = event.getY()/tileSize;
        int col = event.getX()/tileSize;
        game.slide(row, col);
        updateLabelValuesAndPositions();
    }
}
