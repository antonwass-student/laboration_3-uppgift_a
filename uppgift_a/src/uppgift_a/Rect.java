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
