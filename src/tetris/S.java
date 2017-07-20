package tetris;

import java.awt.Color;
import java.awt.Graphics2D;

public class S extends TetrisShape{
    int state=0;
    public void draw(Graphics2D G){
        color = Color.BLUE;
        
            if(state==1){
                MySegArray[0].xTop=oxTop;
                MySegArray[0].yTop=oyTop;
                MySegArray[1].xTop=oxTop+20;
                MySegArray[1].yTop=oyTop+20;
                MySegArray[2].xTop=oxTop;
                MySegArray[2].yTop=oyTop+20;
                MySegArray[3].xTop=oxTop+20;
                MySegArray[3].yTop=oyTop+40;
            }
            else{
                MySegArray[0].xTop=oxTop;
                MySegArray[0].yTop=oyTop;
                MySegArray[1].xTop=oxTop;
                MySegArray[1].yTop=oyTop+20;
                MySegArray[2].xTop=oxTop-20;
                MySegArray[2].yTop=oyTop+20;
                MySegArray[3].xTop=oxTop+20;
                MySegArray[3].yTop=oyTop;
            }
            
            for(Segment curSeg: MySegArray){
            curSeg.draw(G,true,color);
        }      
    }
    
    @Override
    public void OccupyCurSpace(int YTopLeftSeg,int XTopLeftSeg,Segment[][] twoDSegArray){
        if(state==1){
                twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy2();//top left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy2();//top right
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupy2();//bot left
                twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupy2();/*bot right*/}
        else{
                twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy2();//top left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy2();//top right
                twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupy2();//bot left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupy2();/*real bot left*/}
    }
    
  
    @Override
    boolean MoveDownValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray) {
        if(state==1){
            if(oyTop<=70+379){
                return twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true
                        && twoDSegArray[YTopLeftSeg+3][XTopLeftSeg+1].Occupied != true;
                }
            else 
                return false;
        }
        else
            if(oyTop<=90+379){
                return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true;
                }
            else 
                return false;
        
    } 
    
    @Override
    public boolean MoveLeftValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(state==1){
            if(oxTop>285)
            {
                return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                    && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                    && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true;
            }
            else
                return false;
        }
        else
            if(oxTop>305)
            {
                return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                    && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-2].Occupied != true;
            }
            else
                return false;
    }
    
    @Override
    public boolean MoveRightValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(state==1){
            if(oxTop<485){
                return twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupied != true
                    && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true
                    && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+2].Occupied != true;
                }
                else
                    return false;
            }
        else{
            
            if(oxTop<485){
                return twoDSegArray[YTopLeftSeg][XTopLeftSeg+2].Occupied != true
                    && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupied != true;
                }
                else
                    return false;
            }
       
        
    }
    
    public void Rotate(){
        if(state==0)
            state=1;      
        else
            state=0; 
        }
    
    boolean IsRotateValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        if(state==1){
            if(oxTop>285&&oyTop<449&&oxTop<485){
                return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                       && twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupied != true;
            }
            else
                return false;
        }
        else{
            if(oxTop>265&&oyTop<449){
                return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupied != true
                       && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true;
            }
            else 
                return false;
        }    
    }
    
    boolean IsGetRandShapeValid(Segment[][] twoDSegArray){
        return twoDSegArray[1][4].Occupied != true 
                || twoDSegArray[1][5].Occupied != true
                || twoDSegArray[0][5].Occupied != true
                || twoDSegArray[0][6].Occupied != true;
    }
}

