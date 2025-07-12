/*
 * Name: Brian Mayfield
 * File name: DrawShapes.java
 * Date: September 10, 2022
*/

// package name
package cmsc335project2;

// imports
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// public class DrawShapes
public class DrawShapes extends JPanel{
    
    // serial constant
    private static final long serialVersionUID = 1L;
    
    // variables
    private String shape;
    private double dimensions[], minor_Radius;
    private double width, height, radius, length, base;
    
    // constructor
    public DrawShapes(String shape, double[] dim) {
        this.shape = shape;
        dimensions = dim;
    }
    
    // public void paintComponent(Graphics g)
    public void paintComponent(Graphics g) {
        
        // calls the paintComponent of the super class
        super.paintComponent(g);
        
        // a try method is used since image files are used
        try {
            // if the shape chosen is a Circle, then a Circle is drawn
            if(shape.equals("Circle")) {
                radius = dimensions[0];
                
                g.setColor(Color.CYAN);
                g.fillOval((int) (WIDTH / 2 - radius / 4), (int) (HEIGHT / 2 - radius / 4), (int) (2 * radius), (int) (2 * radius));
            }
            // if the shape chosen is Square, then a Square is drawn
            else if(shape.equals("Square")) {
                length = dimensions[0];
                
                g.setColor(Color.GREEN);
                g.fillRect((int) (WIDTH / 2 - length / 4), (int) (HEIGHT / 2 - length / 4), (int) (2 * length), (int) (2 * length));
            }
            // if the shape chosen is a Triangle, then a Triangle is drawn
            else if(shape.equals("Triangle")) {
                height = dimensions[0];
                base = dimensions[1];
                
                g.setColor(Color.BLUE);
                int[] x = {
                    (int) (WIDTH / 2) - (int) (base / 4) 
                        - (int) (height / 2),
                    (int) (WIDTH / 2) + (int) (2 * base), (int) (WIDTH / 2)
                        + (int) (base / 4) + (int) (HEIGHT / 2)
                };
                int[] y = {
                    (int) (HEIGHT / 2) + (int) (2 * height),
                        (int) (HEIGHT / 2) - (int) (base / 2)
                        - (int) (height / 2),
                        (int) (HEIGHT / 2) + (int) (2 * height)
                };
                g.fillPolygon(x, y, 3);
            }
            // if the shape chosen is a Rectangle, then a Rectangle is drawn
            else if(shape.equals("Rectangle")) {
                length = dimensions[0];
                width = dimensions[1];
                
                g.setColor(Color.MAGENTA);
                g.fillRect((int) (WIDTH / 2 - length / 4),
                        (int) (HEIGHT / 2 - length / 4), (int) (2 * width),
                        (int) (2 * length));
            }
            // if the user chooses 3D shapes, then the following code is executed
            else {
                Image image = null;
                
                // if the shape chosen is a Sphere, display the image of Sphere of the selected size
                if(shape.equals("Sphere")) {
                    radius = dimensions[0];
                    
                    if(radius == 1) {
                        image = ImageIO.read(new File("Sphere50.jpg"));
                    }
                    else if(radius == 2) {
                        image = ImageIO.read(new File("Sphere100.jpg"));
                    }
                    else {
                        image = ImageIO.read(new File("Sphere150.jpg"));
                    }
                }
                // if the shape chosen is a Cube, display the imagde of a Cube of the selected size
                else if(shape.equals("Cube")) {
                    double edge = dimensions[0];
                    
                    if(edge == 1) {
                        image = ImageIO.read(new File("Cube50.jpg"));
                    }
                    else if(edge == 2) {
                        image = ImageIO.read(new File("Cube100.jpg"));
                    }
                    else {
                        image = ImageIO.read(new File("Cube150.jpg"));
                    }
                }
                // if the shape chosen is a Cone, then display the image of a Cone of the selected size
                else if(shape.equals("Cone")) {
                    radius = dimensions[0];
                    
                    if(radius == 1) {
                        image = ImageIO.read(new File("Cone50.jpg"));
                    }
                    else if(radius == 2) {
                        image = ImageIO.read(new File("Cone100.jpg"));
                    }
                    else {
                        image = ImageIO.read(new File("Cone150.jpg"));
                    }
                }
                // if the shape chosen is a Cylinder, then display the image of a Cylinder of the selected size
                else if(shape.equals("Cylinder")) {
                    radius = dimensions[0];
                    
                    if(radius == 1) {
                        image = ImageIO.read(new File("Cylinder50.jpg"));
                    }
                    else if(radius == 2) {
                        image = ImageIO.read(new File("Cylinder100.jpg"));
                    }
                    else {
                        image = ImageIO.read(new File("Cylinder150.jpg"));
                    }
                }
                // if the shape chosen is a Torus, then display the image of a Torus of the selected size
                else if(shape.equals("Torus")) {
                    minor_Radius = dimensions[0];
                    
                    if(minor_Radius == 1) {
                        image = ImageIO.read(new File("torus100.jpg"));
                    }
                    else if(minor_Radius == 2) {
                        image = ImageIO.read(new File("torus150.jpg"));
                    }
                    else {
                        image = ImageIO.read(new File("torus200.jpg"));
                    }
                }
                g.drawImage(image, WIDTH / 4, HEIGHT / 4, null);
            }
        }
        
        // if any exception is raised, then catch the exception and display the information to the user
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "The image for the selected shape wasn't found!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
