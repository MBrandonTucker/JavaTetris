package tetris;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Box extends JPanel implements KeyListener{
    private static Box instance = null;
    Segment[][] twoDSegArray = new Segment[20][12];
    boolean running = true;
    int Score = 0;
    String Sscore;
    int height;
    int width;
    int rows = 20;
    int columns = 12;
    static int TopX = 285;
    static int TopY = 90;
    int realXTop = TopX-10;
    int realYTop = TopY+11;
    int Delay=1000;
    TetrisShape CurShape;
    
   // O Square = new O();
    int YTopLeftSeg = 0;
    int XTopLeftSeg = 5;
    Keys myKeys = new Keys();
    int TimerDelay=350;
    Timer timer;
    
    
    
    static Box getInstance(){
        if(instance == null){
            instance = new Box();
            return instance;
        }
        else
            return instance;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Keys extends KeyAdapter{
         @Override
         public void keyPressed(KeyEvent e){
            int code = e.getKeyCode();
            if(code == KeyEvent.VK_DOWN){
                if(CurShape.MoveDownValid(YTopLeftSeg, XTopLeftSeg, twoDSegArray)==true){
                     CurShape.moveDown();
                     YTopLeftSeg++;
                    
                }
            }
            else if(code == KeyEvent.VK_RIGHT){
                if(CurShape.MoveRightValid(YTopLeftSeg, XTopLeftSeg, twoDSegArray)==true
                        &&CurShape.IsGetRandShapeValid(twoDSegArray)!=false){
                     CurShape.moveRight();
                     XTopLeftSeg++;
                     
                }
            }
            else if(code == KeyEvent.VK_LEFT){
                if(CurShape.MoveLeftValid(YTopLeftSeg, XTopLeftSeg, twoDSegArray)==true
                        &&CurShape.IsGetRandShapeValid(twoDSegArray)!=false){    
                    CurShape.moveLeft();
                    XTopLeftSeg--;
                    
                }
            } 
            else if(code == KeyEvent.VK_UP){
                if(CurShape.IsRotateValid(YTopLeftSeg, XTopLeftSeg, twoDSegArray)==true
                        &&CurShape.IsGetRandShapeValid(twoDSegArray)!=false){
                    CurShape.Rotate();   
                    
                }
       } 
    }
    
    public void keyTyped(KeyEvent e){};
    public void keyReleased(KeyEvent e){};
    }
   
    public class TimeEvent implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent ae){
            if(CurShape.MoveDownValid(YTopLeftSeg, XTopLeftSeg, twoDSegArray)==true){
                CurShape.moveDown();
                YTopLeftSeg++;  
            }
            else if(CurShape.IsGetRandShapeValid(twoDSegArray)==true){  
                CurShape.OccupyCurSpace(YTopLeftSeg, XTopLeftSeg, twoDSegArray);
                CurShape=CurShape.GetRandShape();
                YTopLeftSeg = 0;
                XTopLeftSeg = 5;
                CurShape.oxTop=385;
                CurShape.oyTop=110;  
            }
            else
                running = false;   
            //repaint();
        }
    }
    
    private Box(){
        CurShape= new O();
        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
                twoDSegArray[i][j] = new Segment();
            }
        }
        
        TimeEvent T = new TimeEvent();
        timer = new Timer(TimerDelay,T);
        timer.setInitialDelay(3000);
        timer.start();
        /*
        if(CurShape.IsGetRandShapeValid(twoDSegArray)==false){
            timer.stop();
        
                */
    }
    
    Box(int x, int y){
        TopX=x;
        TopY=y;
        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
                twoDSegArray[i][j] = new Segment();
            }
        }      
    }
    
    public void draw(Graphics2D g){
        if(running == true){
           int inc=0;
        int inc1=0;
        for(int i = 0; i<rows; i++){
            inc1+=20;
            inc=0;
            
            for(int j =0; j<columns; j++){
                twoDSegArray[i][j].xTop = TopX + inc;
                twoDSegArray[i][j].yTop = TopY + inc1;
                inc += 20;
                
                if(twoDSegArray[i][j].Occupied1==true){
                    twoDSegArray[i][j].draw(g,true,Color.RED);
                }
                else if(twoDSegArray[i][j].Occupied2==true){
                     twoDSegArray[i][j].draw(g,true,Color.BLUE);
                }
                else if(twoDSegArray[i][j].Occupied3==true){
                     twoDSegArray[i][j].draw(g,true,Color.GREEN);
                }
                else if(twoDSegArray[i][j].Occupied4==true){
                     twoDSegArray[i][j].draw(g,true,Color.MAGENTA);
                }
                else if(twoDSegArray[i][j].Occupied5==true){
                     twoDSegArray[i][j].draw(g,true,Color.YELLOW);
                }
                else    
                    twoDSegArray[i][j].draw(g,false,Color.WHITE);
            }
        }
        
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(20));
        Stroke oldStroke = g.getStroke();
        g.drawRect(realXTop, realYTop, 260, 419); //BIG rect
        g.setStroke(oldStroke);
        CurShape.draw(g);
        //requestFocus();   
        DeleteFullRows(g);
        g.setColor(Color.RED);
        Sscore = Integer.toString(Score);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
        g.drawString("Score:",50,50);
        g.drawString(Sscore,150,50);
        //repaint();     
        }
        else{
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
            g.drawString("Game Over",250,250);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
            g.drawString("Final Score:",270,290);
            g.drawString(Sscore,460,290);
        } 
    }
    
    public void DeleteFullRows(Graphics2D g){
        Segment[][] TempRow = new Segment[20][12];
        boolean foundRow = true;
        for(int i = 0; i<rows; i++){     
            for(int j =0; j<columns; j++){
                if( twoDSegArray[i][j].Occupied==false ){
                    foundRow = false;
                    }    
                }
            if(foundRow == true){
                if(TimerDelay>170){
                    TimerDelay=TimerDelay-8;
                    timer.setDelay(TimerDelay);
                }
                else
                    timer.setDelay(TimerDelay);
                Score = Score + 10;
                for(int k=0; k<i;k++){
                    for(int j =0; j<columns; j++){
                        twoDSegArray[i-k][j]=twoDSegArray[i-(1+k)][j];
                    }
                } 
                for(int j =0; j<columns; j++){
                        twoDSegArray[0][j]=new Segment();
                    }
            }
            else
                foundRow = true;
    }      
}
    
}