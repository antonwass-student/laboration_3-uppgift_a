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
        super();
        
    }
    
    public double getX2(){
        return x2;
    }
    
    public double getY2(){
        return y2;
    }
    
    
    @Override
    public void paint(GraphicsContext gc){
    }
}
