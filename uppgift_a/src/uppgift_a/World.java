package uppgift_a;

import javafx.scene.paint.Color;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2015-09-16
 */
public class World {

    private double width, height; // this worlds width and height

    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this worl
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new Shape[4]; // an array of references (change to non-zero size)
        // Create the actual Shape objects (sub types)
        // ....
        shapes[0] = new Line(10, 10, Color.BLUE, 70,120);
        shapes[0].setVelocity(250,170);
        
        shapes[1] = new Circle(300, 10, Color.RED, true,20);
        shapes[1].setVelocity(-150, 160);
        
        shapes[2] = new Circle(150, 200, Color.BLACK, false, 40);
        shapes[2].setVelocity(150, 160);
        
        shapes[3] = new Rect(150, 250, Color.GREEN, false, 20, 40);
        shapes[3].setVelocity(-150, 160);
    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elpsed time in nanoseconds
     */
    public void move(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (int i = 0; i < shapes.length; i++) { 
            shapes[i].move(elapsedTimeNs);
            shapes[i].constrain(0, 0, width, height);
            
            if(shapes[i] instanceof FillableShape)
            {
                FillableShape temp = (FillableShape)shapes[i];
                if(temp.getDx() < 0){
                    temp.setFilled(true);
                }
                else{
                    temp.setFilled(false);
                }
            }
        }
        System.out.println(width + ", " + height);
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
}
