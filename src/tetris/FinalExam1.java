//Brandon Tucker Systems Analysis final project

package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FinalExam1 extends JPanel implements  KeyListener, FocusListener{
    
    static int x = 385;
    static int y = 110;
    
    O Square = new O();
    Box BigBox = Box.getInstance();

   
    
    public FinalExam1(){
              
    }
    
    public void ChangeY() {
           y = y + 20;
           repaint();
     }

    public void keyPressed(KeyEvent e){
       int code = e.getKeyCode();
       if(code == KeyEvent.VK_RIGHT){
           if(x<BigBox.TopX+419){
            //Square.moveRight();
           }
       }
       if(code == KeyEvent.VK_LEFT){
           if(x>295){    
               //Square.moveLeft();
           }
       } 
    }
    
    public void keyTyped(KeyEvent e){};
    public void keyReleased(KeyEvent e){};
    public void focusGained(FocusEvent evt){
        repaint();
    };
    public void focusLost(FocusEvent evt){
        repaint();
    };
   
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g.setColor(Color.RED);
        //Square.draw(g2);
        //g.setColor(Color.BLACK);
        BigBox.draw(g2);  
        //requestFocus();
        repaint();         
    }
    
    public static void main(String[] args) {      
        
        ///music section
        
        File audioFile = new File("src/tetris/Music folder/tetris.wav"); 
        AudioInputStream audioStream = null;
        try{
        audioStream = AudioSystem.getAudioInputStream(audioFile);
        }
        catch(UnsupportedAudioFileException|IOException e){
        e.printStackTrace();
        }
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        try{ 
        Clip audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
        audioClip.start();
        audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        }catch(LineUnavailableException|IOException e){
        e.printStackTrace();
        }
        
        
        JFrame f = new JFrame();
        FinalExam1 S = new FinalExam1(); 
        f.add(S);
        f.addKeyListener(S.BigBox.myKeys);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,600);
        
      
                
         
    }
}
