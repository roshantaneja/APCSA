
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
        JLabel fileNameLabel = new JLabel("File Name:");
        add(fileNameLabel, NORTH);
        fileNameField = new JTextField("Colorado_480x480.txt", 18);
        add(fileNameField, NORTH);
        JLabel sizeLabel = new JLabel("Map Size:");
        add(sizeLabel, NORTH);
        
        rowsField = new JTextField("480", 3);
        add(rowsField, NORTH);
        
        JLabel xLabel = new JLabel("x");
        add(xLabel, NORTH);
        
        colsField = new JTextField("480", 3);
        add(colsField, NORTH);
        
        loadButton = new JButton("Load File");
        add(loadButton, NORTH);
        
        drawButton = new JButton("Draw Map");
        drawButton.setEnabled(false);
        add(drawButton, NORTH);
        
        findPathButton = new JButton("Find Path");
        findPathButton.setEnabled(false);
        add(findPathButton, NORTH);
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
        removeAll();
        String fileName = fileNameField.getText();
        int rows = Integer.parseInt(rowsField.getText());
        int cols = Integer.parseInt(colsField.getText());
        mountainMap = new TopographicMap(fileName, rows, cols);
        
        if (mountainMap.isValid()){
            JOptionPane.showMessageDialog(this, "Map Loaded Successfully!");
            drawButton.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "No bueno");
        }
    }


}
