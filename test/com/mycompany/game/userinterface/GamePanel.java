/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.userinterface;

import GameObject.GameWorld;
//import GameObject.MegaMan;
import GameObject.PhysicalMap;
import com.mycompany.effect.Animation;
import com.mycompany.effect.CacheDataLoader;
import com.mycompany.effect.FrameImage;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ThisPC
 */
public class GamePanel extends JPanel implements Runnable, KeyListener{
    private Thread thread;
    private boolean isRunning=true;
    private InputManager inputManager;
    private BufferedImage bufImage;
    private Graphics2D bufG2D;
    GameWorld gameWorld;
    

    FrameImage fr1;
    Animation an1;
    
    public GamePanel(){
        gameWorld = new GameWorld();
        inputManager = new InputManager(gameWorld);  
        bufImage = new BufferedImage(GameFrame_Multi_Player_Mode.SCREEN_WIDTH, GameFrame_Multi_Player_Mode.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        an1 = CacheDataLoader.getInstance().getAnimation("tele");
        fr1 = CacheDataLoader.getInstance().getFrameImage("tele14");                   
//        an1.flipAllImage();        
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(bufImage, 0, 0, this);       
    }
    //updategame
    public void Updategame(){
        gameWorld.Update();
    }
    //render
    public void RenderGame(){
        if(bufImage == null){
            bufImage=new BufferedImage(GameFrame_Multi_Player_Mode.SCREEN_WIDTH, GameFrame_Multi_Player_Mode.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        if(bufImage != null){
            bufG2D=(Graphics2D) bufImage.getGraphics();           
        }
        if(bufImage != null){
//            bufG2D.setColor(Color.WHITE);
//            bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
            gameWorld.Render(bufG2D);
//           an1.draw(100, 100, bufG2D);
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
            an1.Update(System.nanoTime());

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
        inputManager.processkeyReleased(e.getKeyCode());
    }


    
}
