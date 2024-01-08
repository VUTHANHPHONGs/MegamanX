/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class GamePanel extends JPanel implements Runnable,KeyListener{
    private Thread thread;
    private boolean isRunning=true;
    private InpuManager1 inputManager;
    private BufferedImage bufImage;
    private Graphics2D bufG2D;
    GameWorld_1 gameWorld_1;
    public GamePanel(){
        gameWorld_1=new GameWorld_1();
        inputManager = new InpuManager1(gameWorld_1);
        bufImage = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_ARGB);
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(bufImage, 0, 0, this);       
    }
    public void Updategame(){
        gameWorld_1.Update();
    }public void RenderGame(){
        if(bufImage == null){
            bufImage=new BufferedImage(1000, 600, BufferedImage.TYPE_INT_ARGB);
        }
        if(bufImage != null){
            bufG2D=(Graphics2D) bufImage.getGraphics();           
        }
        if(bufImage != null){
//            bufG2D.setColor(Color.WHITE);
//            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            gameWorld_1.Render(bufG2D);
//            fr1.draw(300, 200, bufG2D);                      
        }
    }
    
    
    public void startGame(){
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void run(){
        long FPS = 120;
        long period=1000*1000000/FPS;
        long beginTime;
        long sleepTime;
        int a =1;
        beginTime=System.nanoTime();
        while(isRunning){
            //Update
            //Render
            Updategame();
            RenderGame();

            repaint();


            long deltaTime = System.nanoTime()-beginTime;
            sleepTime=period - deltaTime;
            try {
                if(sleepTime >0){
                    Thread.sleep(sleepTime/1000000);
                }
                else Thread.sleep(period/2000000);
              
            } catch (InterruptedException ex) {
            }
            beginTime = System.nanoTime();

            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.processKeyPressed(e.getKeyCode());
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputManager.processKeyReleased(e.getKeyCode());
    }
    
}
