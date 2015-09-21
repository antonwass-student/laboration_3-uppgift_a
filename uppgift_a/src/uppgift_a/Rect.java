/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_a;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author anton
 */
public class Rect extends FillableShape{
    private double width, height;
    public Rect(double x, double y, Color color, boolean fill, double width, double height){
        super(x, y, color, fill);
        this.width = width;
        this.height = height;
        
    }
    
    public void constrain(
            double boxX, double boxY, 
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        if (getX() < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } else if (getX() + width  > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        if (getY() < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } else if (getY() + height > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }
    
    @Override
    public void paint(GraphicsContext gc){
        
        if(getFilled()){
            gc.setFill(getColor());
            gc.fillRect(getX(), getY(), width, height);
        }
        else{
            gc.setStroke(getColor());
            gc.strokeRect(getX(), getY(), width, height);
        }
    }
}
