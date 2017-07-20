package tetris;

import java.awt.Color;
import java.awt.Graphics2D;

public class I extends TetrisShape{
    int state=0;
    public void draw(Graphics2D G){
        color = Color.GREEN;
        if(state==0){
            MySegArray[0].xTop=oxTop;
            MySegArray[0].yTop=oyTop;
            MySegArray[1].xTop=oxTop;
            MySegArray[1].yTop=oyTop+20;
            MySegArray[2].xTop=oxTop;
            MySegArray[2].yTop=oyTop+40;
            MySegArray[3].xTop=oxTop;
            MySegArray[3].yTop=oyTop+60;
        }
        else{
            MySegArray[0].xTop=oxTop-40;
            MySegArray[0].yTop=oyTop;
            MySegArray[1].xTop=oxTop-20;
            MySegArray[1].yTop=oyTop;
            MySegArray[2].xTop=oxTop;
            MySegArray[2].yTop=oyTop;
            MySegArray[3].xTop=oxTop+20;
            MySegArray[3].yTop=oyTop;
        }
        
       
        for(Segment curSeg: MySegArray){
            curSeg.draw(G,true,color);
        }
    }
    
    @Override
    public void OccupyCurSpace(int YTopLeftSeg,int XTopLeftSeg,Segment[][] twoDSegArray){
                if(state==0){
                    twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy3();//top left
                    twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy3();//top right
                    twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupy3();//bot left
                    twoDSegArray[YTopLeftSeg+3][XTopLeftSeg].Occupy3();//bot right
                }
                else{
                    twoDSegArray[YTopLeftSeg][XTopLeftSeg-2].Occupy3();//top left
                    twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupy3();//top right
                    twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy3();//bot left
                    twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupy3();//bot right
                }
                
    }
    
  
    @Override
    boolean MoveDownValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray) {
        if(state==0){
            if(oyTop<=50+379){
                return twoDSegArray[YTopLeftSeg+4][XTopLeftSeg].Occupied != true;
            }
            else 
                return false;
        }
        else{
            if(oyTop<=110+379){
                return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-2].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupied != true;
            }
            else 
                return false;
        }
    } 
    
    
    @Override
    public boolean MoveLeftValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(state==0&&oxTop>285)
        {
            return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg-1].Occupied != true
                && twoDSegArray[YTopLeftSeg+3][XTopLeftSeg-1].Occupied != true;
        }
        else if(state==1&&oxTop>325)
            return twoDSegArray[YTopLeftSeg][XTopLeftSeg-3].Occupied != true;
        else
            return false;
    }
    
    @Override
    public boolean MoveRightValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(state==0&&oxTop<505)
        {
             return twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupied != true
                && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupied != true
                && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true
                && twoDSegArray[YTopLeftSeg+3][XTopLeftSeg+1].Occupied != true;
        }
        else if(state==1&&oxTop<485)
            return twoDSegArray[YTopLeftSeg][XTopLeftSeg+2].Occupied != true;
        else 
            return false;
      
    }
    
    public void Rotate(){
        if(state==0)
            state=1;      
        else
            state=0; 
        }
            
    boolean IsRotateValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(505>oxTop&&oxTop>305&&oyTop<429){
            return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-2].Occupied != true
                && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupied != true
                    //check for both states
                && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true
                && twoDSegArray[YTopLeftSeg+3][XTopLeftSeg].Occupied != true;
            
            }
        else
            return false;
                
        
    }
    
    
    boolean IsGetRandShapeValid(Segment[][] twoDSegArray){
        return twoDSegArray[0][5].Occupied != true
                ||twoDSegArray[1][5].Occupied != true
                ||twoDSegArray[2][5].Occupied != true
                ||twoDSegArray[3][5].Occupied != true;
    }
    
}
