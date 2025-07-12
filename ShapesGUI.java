/*
 * Name: Brian Mayfield
 * File name: ShapesGUI.java
 * Date: September 11, 2022
*/

// package name
package cmsc335project2;

// imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// public class ShapesGUI
public class ShapesGUI extends JFrame implements ActionListener {
    
    // serial constant
    private static final long serialVersionUID = 1L;
    
    // variables
    private JButton[] Two_D_Three_D_Shapes;
    JPanel drawingPanel;
    DrawShapes drawing;
    String input1, input2;
    double base, height, side, width, length, radius;
    
    // constructor
    public ShapesGUI() {
        
        // define the DrawShapes object
        drawing = new DrawShapes(" ", new double[] { 0 });
        
        // define the Panel to hold the drawing object
        drawingPanel = new JPanel(new BorderLayout(500, 500));
        drawingPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10));
        
        // set the default border
        setLayout(new BorderLayout());
        
        // define the button panel and add the buttons and add actions to each button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(9, 1));
        String[] shapeNames = { "Circle", "Square", "Triangle", "Rectangle",
            "Sphere", "Cube", "Cone", "Cylinder", "Torus" };
        Two_D_Three_D_Shapes = new JButton[shapeNames.length];
        for(int i = 0; i < Two_D_Three_D_Shapes.length; i++) {
            Two_D_Three_D_Shapes[i] = new JButton(shapeNames[i]);
            Two_D_Three_D_Shapes[i].addActionListener(this);
            buttonPanel.add(Two_D_Three_D_Shapes[i]);
        }
        
        // add the buttons panel
        add(buttonPanel, BorderLayout.WEST);
        
        // add the drawingPanel
        add(drawingPanel, BorderLayout.CENTER);
    }
    
    // actionPerformed() method to perform actions based on button clicks
    public void actionPerformed(ActionEvent ae) {
        
        // get the command
        String clicked = ae.getActionCommand();
        try {
            // if the Circle button is clicked, get the information to display the Circle
            if(clicked.equals("Circle")) {
                String input1 = JOptionPane.showInputDialog("Enter the radius: ");
                
                radius = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes("Circle", new double[] { radius });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Square button is clicked, get the information to display the Square
            else if(clicked.equals("Square")) {
                input1 = JOptionPane.showInputDialog("Enter the side: ");
                
                side = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { side });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
            }
            // if the Triangle button is clicked, get the information to display the Triangle
            else if(clicked.equals("Triangle")) {
                input1 = JOptionPane.showInputDialog("Enter the base: ");
                input2 = JOptionPane.showInputDialog("Enter the height: ");
                
                base = Double.parseDouble(input1);
                height = Double.parseDouble(input2);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { base, height });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Rectangle button is clicked, get the information to display the Rectangle
            else if(clicked.equals("Rectangle")) {
                input1 = JOptionPane.showInputDialog("Enter the width: ");
                input2 = JOptionPane.showInputDialog("Enter the length: ");
                
                width = Double.parseDouble(input1);
                length = Double.parseDouble(input2);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { width, length });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Sphere button is clicked, get the information to display the Sphere
            else if(clicked.equals("Sphere")) {
                input1 = JOptionPane.showInputDialog("Select one of the options to display the Sphere: \n1. Small\n2. Medium\n3.Large");
                
                radius = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { radius });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Cube button is clicked, get the information to display the Cube
            else if(clicked.equals("Cube")) {
                input1 = JOptionPane.showInputDialog("Select one of the options to display the Cube: \n1. Small\n2. Medium\n3.Large");
                
                length = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { length });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Cone button is clicked, get the information to display the Cone
            else if(clicked.equals("Cone")) {
                input1 = JOptionPane.showInputDialog("Select one of the options to display the Cone: \n1. Small\n2. Medium\n3. Large");
                
                length = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { radius });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Cylinder button is clicked, get the information to display the Cylinder
            else if(clicked.equals("Cylinder")) {
                input1 = JOptionPane.showInputDialog("Select one of the options to display the Cylinder: \n1. Small\n2. Medium\n3. Large");
                
                length = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { length });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
            // if the Torus button is clicked, get the information to display the Torus
            else {
                String input1 = JOptionPane.showInputDialog("Select one of the options to display the Torus: \n1. Small\n2. Medium\n3. Large");
                
                length = Double.parseDouble(input1);
                drawingPanel.remove(drawing);
                drawing = new DrawShapes(clicked, new double[] { length });
                drawingPanel.add(drawing, BorderLayout.CENTER);
                drawingPanel.revalidate();
                drawingPanel.repaint();
            }
        }
        // to catch the exception
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Not valid input");
        }
    }
    
    // main() method
    public static void main(String[] args) {
        
        // creates the object of the ShapesGUI JFrame
        ShapesGUI gui = new ShapesGUI();
        gui.setSize(700, 600);
        gui.setResizable(false);
        gui.setTitle("Shape Theme Simulation Program");
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
