package tetris;

import java.awt.Color;
import java.awt.Graphics2D;

public class O extends TetrisShape{
    
    public void draw(Graphics2D G){
        color = Color.RED;
        
        MySegArray[0].xTop=oxTop;
        MySegArray[0].yTop=oyTop;
        MySegArray[1].xTop=oxTop+20;
        MySegArray[1].yTop=oyTop;
        MySegArray[2].xTop=oxTop;
        MySegArray[2].yTop=oyTop+20;
        MySegArray[3].xTop=oxTop+20;
        MySegArray[3].yTop=oyTop+20;
        for(Segment curSeg: MySegArray){
            if(curSeg.Occupied==true){
                curSeg.draw(G,true,color);
            }
            else
                curSeg.draw(G,false,color);
            
        }
    }
    
    @Override
   public void OccupyCurSpace(int YTopLeftSeg,int XTopLeftSeg,Segment[][] twoDSegArray){
            twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy1();//top left
            twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy1();//top right
            twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupy1();//bot left
            twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupy1();//bot right
            //twoDSegArray[YTopLeftSeg][XTopLeftSeg].Clear();
               
    }
   
   public boolean MoveDownValid(int YTopLeftSeg,int XTopLeftSeg,Segment[][] twoDSegArray){
       if(oyTop<=90+379){
        return (twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true
                && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true);
       }
       else 
           return false;
    }
   
    
    @Override
    public boolean MoveLeftValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(oxTop>285)
        {
            return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true;
        }
        else
            return false;
    }
    
    @Override
    public boolean MoveRightValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(oxTop<485)
        {
            return twoDSegArray[YTopLeftSeg][XTopLeftSeg+2].Occupied != true
                && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true;
        }
        else
            return false;
        
    }
    
    
    boolean IsGetRandShapeValid(Segment[][] twoDSegArray){
        return twoDSegArray[1][5].Occupied != true 
                || twoDSegArray[1][6].Occupied != true
                || twoDSegArray[0][5].Occupied != true
                || twoDSegArray[0][6].Occupied != true;
    }
    
}