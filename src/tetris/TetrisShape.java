package tetris;

import static com.oracle.nio.BufferSecrets.instance;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class TetrisShape {
    
    CurrentState State;
    Segment[] MySegArray = new Segment[4];
    int oxTop = 385;
    int oyTop = 110;
    static float dash1[] = { 1.0f };
    public Color color = Color.BLUE;
    Random random = new Random();
    int someInt;
    Box myBox;
    
    TetrisShape(){
        
        someInt = random.nextInt(5) + 1;
        MySegArray[0] = new Segment();
        MySegArray[1] = new Segment();
        MySegArray[2] = new Segment();
        MySegArray[3] = new Segment();
        MySegArray[0].Occupy();
        MySegArray[1].Occupy();
        MySegArray[2].Occupy();
        MySegArray[3].Occupy();
    }

    boolean MoveDownValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean MoveLeftValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
       throw new UnsupportedOperationException("Not supported yet.");
    
    }
    
    public boolean MoveRightValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    interface CurrentState{
        public void rotate();
    }
    
    public void moveLeft(){
        oxTop-=20;
    }
    
    public void moveRight(){
        oxTop+=20;
    }
    
    public void rotate(){
        
    }
    
    public void moveDown(){
        oyTop+=20;
    }
    
    TetrisShape GetRandShape(){
        TetrisShape Shape = new TetrisShape();
        
        
        switch(someInt){
            case 1: Shape =  new O();
                break;
            case 2: Shape = new S();
                break;
            case 3: Shape = new I();
                break;
            case 4: Shape = new T();
                break;
            case 5: Shape = new L();
                break;
            default:
                break;
        }
        return Shape;
    }
    
    public void draw(Graphics2D G){
        
    }
    
    Color GetColor(){
        return color;
    }
    
    public void OccupyCurSpace(int YTopLeftSeg,int XTopLeftSeg,Segment[][] twoDSegArray){
        
    }
    
    void Rotate(){
        
    }
    
    boolean IsRotateValid(int YTopLeftSeg, int XTopLeftSeg, Segment[][] twoDSegArray){
        return true;
    }
    
    boolean IsGetRandShapeValid(Segment[][] twoDSegArray){
        return true;
    }
    
    void makeInvisible(){
        for(int i=0; i<4; i++){
            MySegArray[i].Clear();
        }
    }
    void makeVisible(){
        for(int i=0; i<4; i++){
            MySegArray[i].Occupy();
        }
    }
}
