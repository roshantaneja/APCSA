
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
    private JButton findPathButton, downhillPathButton;
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
        
        downhillPathButton = new JButton("Find Downhill Path");
        downhillPathButton.setEnabled(false);
        add(downhillPathButton, NORTH);
    }

    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == loadButton)
            handleLoadButton();
        if (event.getSource() == drawButton)
            handleDrawButton();
        if (event.getSource() == findPathButton)
            handleFindPathButton();
        if (event.getSource() == downhillPathButton)
            handleDownhillPathButton();
        // more to do here eventually
    }

    private void handleLoadButton()
    {
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
        findPathButton.setEnabled(false);
        downhillPathButton.setEnabled(false);
    }

    private void handleDrawButton(){
        removeAll();
        mountainMap.drawMap(this);
        drawButton.setEnabled(false);
        findPathButton.setEnabled(true);
        downhillPathButton.setEnabled(true);
    }
    
    private void handleFindPathButton(){
        int bestIndex = mountainMap.getIndexOfLowestElevPath(this);
        mountainMap.drawLowestElevPath(this, bestIndex, Color.green);
    }
    
    private void handleDownhillPathButton(){
        int bestIndex = mountainMap.getIndexOfLowestDownhillPath(this);
        mountainMap.drawLowestDownhillPath(this, bestIndex, Color.blue);
    }

}
