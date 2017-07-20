package tetris;

import java.awt.Color;
import java.awt.Graphics2D;

public class T extends TetrisShape{
    int state=0;
    public void draw(Graphics2D G){
        color = Color.magenta;
        switch(state){
            case 0:
                MySegArray[0].xTop=oxTop;
                MySegArray[0].yTop=oyTop;
                MySegArray[1].xTop=oxTop-20;
                MySegArray[1].yTop=oyTop+20;
                MySegArray[2].xTop=oxTop;
                MySegArray[2].yTop=oyTop+20;
                MySegArray[3].xTop=oxTop+20;
                MySegArray[3].yTop=oyTop+20;
                break;
            case 1: 
                MySegArray[0].xTop=oxTop;
                MySegArray[0].yTop=oyTop;
                MySegArray[1].xTop=oxTop;
                MySegArray[1].yTop=oyTop+20;
                MySegArray[2].xTop=oxTop;
                MySegArray[2].yTop=oyTop+40;
                MySegArray[3].xTop=oxTop+20;
                MySegArray[3].yTop=oyTop+20;
                break;
            case 2: 
                MySegArray[0].xTop=oxTop;
                MySegArray[0].yTop=oyTop;
                MySegArray[1].xTop=oxTop+20;
                MySegArray[1].yTop=oyTop;
                MySegArray[2].xTop=oxTop+40;
                MySegArray[2].yTop=oyTop;
                MySegArray[3].xTop=oxTop+20;
                MySegArray[3].yTop=oyTop+20;
                break;
            case 3:  
                MySegArray[0].xTop=oxTop+20;
                MySegArray[0].yTop=oyTop;
                MySegArray[1].xTop=oxTop+20;
                MySegArray[1].yTop=oyTop+20;
                MySegArray[2].xTop=oxTop+20;
                MySegArray[2].yTop=oyTop+40;
                MySegArray[3].xTop=oxTop;
                MySegArray[3].yTop=oyTop+20;
                break;         
        }
        
        for(Segment curSeg: MySegArray){
            curSeg.draw(G,true,color);
        }
    }
    
            
    @Override
    public void OccupyCurSpace(int YTopLeftSeg,int XTopLeftSeg,Segment[][] twoDSegArray){
        switch(state){
            case 0:
                twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy4();//top left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupy4();//top right
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy4();//bot left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupy4();//bot right
                break;
            case 1:
                twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy4();//top left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy4();//top right
                twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupy4();//bot left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupy4();//bot right
                break;
            case 2:
                twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupy4();//top left
                twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupy4();//top right
                twoDSegArray[YTopLeftSeg][XTopLeftSeg+2].Occupy4();//bot left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupy4();//bot right
                break;
            case 3:
                twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupy4();//top left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+1].Occupy4();//top right
                twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupy4();//bot left
                twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupy4();//bot right
                break;
        }
    }
    
  
    @Override
    boolean MoveDownValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray) {
        switch(state){
            case 0:
                if(oyTop<=90+379){
                    return twoDSegArray[YTopLeftSeg+2][XTopLeftSeg-1].Occupied != true
                    && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true
                    && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true;
                        }
                else 
                    return false;
                
            case 1:
                if(oyTop<=70+379){
                    return twoDSegArray[YTopLeftSeg+3][XTopLeftSeg].Occupied != true
                    && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true;
                        }
                else 
                    return false;
            case 2:
                if(oyTop<=90+379){
                    return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupied != true
                    && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true
                    && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true;
                        }
                else 
                    return false;
            case 3:
                if(oyTop<=70+379){
                    return twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true
                    && twoDSegArray[YTopLeftSeg+3][XTopLeftSeg+1].Occupied != true;
                        }
                else 
                    return false;
            
        
        }
        return false;
    } 
    
    public boolean MoveLeftValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        switch(state){
            case 0:
                if(oxTop>305)
                {
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-2].Occupied != true;
                }
                else
                    return false;
            case 1:
                if(oxTop>285)
                {
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg-1].Occupied != true;
                }
                else
                    return false;
            case 2:
                if(oxTop>285)
                {
                      return twoDSegArray[YTopLeftSeg][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupied != true;
                }
                else
                    return false;
            case 3:
                if(oxTop>285)
                {
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true;
                }
                else
                    return false;
        }  
        return false;
    }
    
    @Override
    public boolean MoveRightValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        switch(state){
            case 0:
                if(oxTop<525-40)
                {
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true;
                }
                else
                    return false;
            case 1:
                if(oxTop<525-40)
                {
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true
                        && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true;
                }
                else
                    return false;
            case 2:
                if(oxTop<525-60)
                {
                      return twoDSegArray[YTopLeftSeg][XTopLeftSeg+3].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true;
                }
                else
                    return false;
            case 3:
                if(oxTop<525-40)
                {
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg+2].Occupied != true
                        && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg+2].Occupied != true
                        && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+2].Occupied != true;
                }
                else
                    return false;
        }  
        return false;
        
    }
    
    public void Rotate(){
        
        switch (state){
            case 0:
                state=1;
                break;
            case 1:
                state=2;
                break;
            case 2:
                state=3;
                break;
            case 3:
                state=0;
                break;
        }  
    }
    
    
    boolean IsRotateValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        
        switch (state){
            case 0:
                if(oxTop>285&&oyTop<469&&oxTop<505){
                    return twoDSegArray[YTopLeftSeg+2][XTopLeftSeg].Occupied != true;
                }
                else
                    return false;
            case 1:
                if(oxTop>285&&oyTop<469&&oxTop<485){
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg+2].Occupied != true
                            && twoDSegArray[YTopLeftSeg][XTopLeftSeg+1].Occupied != true;
                }
                else
                    return false;
               
            case 2:
                if(oxTop>265&&oyTop<469&&oxTop<485){
                    return twoDSegArray[YTopLeftSeg+1][XTopLeftSeg].Occupied != true
                            && twoDSegArray[YTopLeftSeg+2][XTopLeftSeg+1].Occupied != true;
                }
                else
                    return false;
            case 3:
                if(oxTop>285&&oyTop<469&&oxTop<485){
                    return twoDSegArray[YTopLeftSeg][XTopLeftSeg].Occupied != true
                            && twoDSegArray[YTopLeftSeg+1][XTopLeftSeg-1].Occupied != true;
                }
                
    }
        return false;
    
    
}

    
    boolean IsGetRandShapeValid(Segment[][] twoDSegArray){
        return twoDSegArray[1][4].Occupied != true 
                || twoDSegArray[1][5].Occupied != true
                || twoDSegArray[1][6].Occupied != true
                || twoDSegArray[0][5].Occupied != true;
    }
}