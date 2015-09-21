/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift_a;

import javafx.scene.paint.Color;

/**
 *
 * @author anton
 */
public abstract class FillableShape extends Shape {
    
    private boolean filled;
    
    public FillableShape(double x, double y, Color color, boolean filled){
        super(x, y, color);
        this.filled = filled;
    }
    
    public boolean getFilled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
}
