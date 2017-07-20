package tetris;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Segment {
    
    Color segColor = Color.GRAY;
    int xTop = 50;
    int yTop = 50;
    int width = 20;
    int height = 20;
    boolean Occupied;
    boolean Occupied1;
    boolean Occupied2;
    boolean Occupied3;
    boolean Occupied4;
    boolean Occupied5;
    
    
    public void Occupy(){
        Occupied=true;
    }
    
    public void Occupy1(){
        Occupied1=true;
        Occupied=true;
    }
    public void Occupy2(){
        Occupied2=true;
        Occupied=true;
    }
    
    public void Occupy3(){
        Occupied3=true;
        Occupied=true;
    }
    
    public void Occupy4(){
        Occupied4=true;
        Occupied=true;
    }
    
    public void Occupy5(){
        Occupied5=true;
        Occupied=true;
    }
    
    public void Clear(){
        Occupied=false;
        Occupied1=false;
        Occupied2=false;
        Occupied3=false;
        Occupied4=false;
        Occupied5=false;
    }
    
    
    Segment(){
        Occupied=false;
    }

    public void draw(Graphics2D g,boolean filled,Color color){
        
        g.setColor(segColor);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{7}, 0);
        g.setStroke(dashed);

        if(filled){
            g.setColor(color);
            g.fill3DRect(xTop, yTop, width, height,true );
        }
        else{
            g.drawRect( xTop, yTop, width, height);
        }
        
        
    }
}
