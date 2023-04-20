
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MountainPathFinder extends GraphicsProgram
{
    private TopographicMap mountainMap;

    private JButton loadButton;
    private JButton drawButton;
    private JButton findPathButton;
    private JTextField fileNameField;
    private JTextField rowsField, colsField;

    public void init()
    {
        setSize(960, 560);
        setTitle("Mountain Path Finder");
        initGUI();
    }

    public void run()
    {
        addActionListeners();
    }

    private void initGUI()
    {
        // you'll do this in task #0
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == loadButton)
            handleLoadButton();
        // more to do here eventually
    }

    private void handleLoadButton()
    {
        // you'll do this in task #2
    }


}
