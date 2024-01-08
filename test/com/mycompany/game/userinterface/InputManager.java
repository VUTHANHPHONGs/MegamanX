/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game.userinterface;

import GameObject.GameWorld;
import GameObject.MegaMan;
import GameObject.MegaMan1;
import java.awt.event.KeyEvent;

/**
 *
 * @author ThisPC
 */
public class InputManager {

    private  GameWorld gameWorld;
    public InputManager(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }
    //xu_li_su_kien_nhan_tha_phim
    public void processKeyPressed(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_A:    
                gameWorld.megaman.setDirection(MegaMan.LEFT_DIR);
                gameWorld.megaman.run();
                break;
            case KeyEvent.VK_W:
                 gameWorld.megaman.jump();
                

                break;
            case KeyEvent.VK_D:
                gameWorld.megaman.setDirection(MegaMan.RIGHT_DIR);
                gameWorld.megaman.run();
                break;  
            case KeyEvent.VK_S:
                gameWorld.megaman.dick();
                break;
            case KeyEvent.VK_ESCAPE:
                break;
            case KeyEvent.VK_ENTER:
                if(gameWorld.state == GameWorld.INIT_GAME){
                    if(gameWorld.previousState == GameWorld.GAMEPLAY)
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    else gameWorld.switchState(GameWorld.TUTORIAL);                   
                }
                if(gameWorld.state == GameWorld.TUTORIAL && gameWorld.storyTutorial >= 1){
                    if(gameWorld.storyTutorial<=6){
                        gameWorld.storyTutorial ++;
                        gameWorld.currentSize = 1;
                       gameWorld. textTutorial = gameWorld.texts1[gameWorld.storyTutorial-1];
                    }else{
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    }                  
                    //  meeting bossl
                    if(gameWorld.tutorialState == GameWorld.MEETFINALBOSS){
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    }
                }
                if(gameWorld.state==GameWorld.GAMEWIN){
                    new ManHinh.Menu_game(null, true).setVisible(true);
                }
                if(gameWorld.state==GameWorld.GAMEOVER){                   
                    new ManHinh.Menu_game(null, true).setVisible(true);
                    
                }
                if(gameWorld.state==GameWorld.GAMEPLAY){
                    gameWorld.megaman1.attack();
                }
                break;
                
            case KeyEvent.VK_SPACE:       
                gameWorld.megaman.attack();

                break;
            case KeyEvent.VK_NUMPAD0:
                gameWorld.megaman1.specialAttack();
                break;
                
    
            case KeyEvent.VK_L:
                    gameWorld.megaman.specialAttack();
                    break;
                        //nhanvat2
            case KeyEvent.VK_RIGHT:
                gameWorld.megaman1.setDirection(MegaMan1.RIGHT_DIR);
                gameWorld.megaman1.run();
                break;
            case KeyEvent.VK_DOWN:
                gameWorld.megaman1.dick();
                break; 
            case KeyEvent.VK_LEFT:
                gameWorld.megaman1.setDirection(MegaMan1.LEFT_DIR);
                gameWorld.megaman1.run();
                break;
            case KeyEvent.VK_UP:
                 gameWorld.megaman1.jump();
               break
                       ;
        }
    }
    public void processkeyReleased(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_A:
                System.out.println("RlLeft");
                if(gameWorld.megaman.getSpeedX() < 0)
                    gameWorld.megaman.stopRun();
                break;
            case KeyEvent.VK_W:
                System.out.println("RlUp");
                break;
            case KeyEvent.VK_D:
                System.out.println("RlRight");
                if(gameWorld.megaman.getSpeedX() > 0)
                    gameWorld.megaman.stopRun();
                break;  
            case KeyEvent.VK_S:
                System.out.println("RlDown");
                gameWorld.megaman.standUp();
                break;
            case KeyEvent.VK_ENTER:
                System.out.println("RlEnter");
                break;
            case KeyEvent.VK_SPACE:
            
                System.out.println("RlSpace");
                break;
            //nhanvat2
            case KeyEvent.VK_RIGHT:
                if(gameWorld.megaman1.getSpeedX() > 0)
                    gameWorld.megaman1.stopRun();
                break;
            case KeyEvent.VK_LEFT:
                if(gameWorld.megaman1.getSpeedX()<0)
                    gameWorld.megaman1.stopRun();
                break;
            case KeyEvent.VK_DOWN:
                gameWorld.megaman1.standUp();
                break;
            default:
               break
                       ;
        }
    }
}
