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
public class Line extends Shape{
    
    private double x2, y2;
    
    public Line(double x, double y, Color color, double x2, double y2){
        super(x, y, color);
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public double getX2(){
        return x2;
    }
    
    public double getY2(){
        return y2;
    }
    
    @Override
    public void move(long elapsedTimeNs){
        setX(getX() + getDx() * elapsedTimeNs / BILLION);
        setY(getY() + getDy() * elapsedTimeNs / BILLION);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy()* elapsedTimeNs / BILLION;
    }
    
    @Override
    public void constrain (double boxX, double boxY, 
            double boxWidth, double boxHeight){
        
        if (getX() < boxX || x2 < boxX) {
            setVelocity(Math.abs(getDx()), getDy());
        } else if (getX() > boxWidth || x2 > boxWidth) {
            setVelocity(-Math.abs(getDx()), getDy());
        }
        if (getY() < boxY || y2 < boxY) {
            setVelocity(getDx(), Math.abs(getDy()));
        } else if (getY() > boxHeight || y2 > boxHeight) {
            setVelocity(getDx(), -Math.abs(getDy()));
        }

        
    }
    @Override
    public void paint(GraphicsContext gc){
        gc.setLineWidth(5);
        gc.setStroke(getColor());
        gc.strokeLine(super.getX(), super.getY(), x2, y2);
        
    }
}
