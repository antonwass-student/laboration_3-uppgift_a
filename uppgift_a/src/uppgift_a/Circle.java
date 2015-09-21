/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_a;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 *
 * @author anton
 */
public class Circle extends FillableShape{
    private double diameter;
    
    public Circle(double x, double y, Color color, boolean filled,
            double diameter){
        super(x, y, color, filled);
        this.diameter = diameter;
    }
    
    public double getDiameter()
    {
        return diameter;
    }
    
    @Override
    public void paint(GraphicsContext gc){
        if(getFilled()){
            gc.setFill(getColor());
            gc.fillOval(getX(), getY(), diameter, diameter);
        }
        else{
            gc.setStroke(getColor());
            gc.strokeOval(getX(), getY(), diameter, diameter);
        }
    }
    
    @Override
    public void constrain(double boxX, double boxY, 
            double boxWidth, double boxHeight){
        // If outside the box - calculate new dx and dy
        if (getX() < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } else if (getX() + diameter > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        if (getY() < boxY) {
            setVelocity(getDx(),Math.abs(getDy()));
        } else if (getY() + diameter > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }
    }
    
}
