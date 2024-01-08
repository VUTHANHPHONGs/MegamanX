/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import GameObject.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author Admin
 */
public class InpuManager1 {
    private GameWorld_1 gameWorld_1;

    public InpuManager1(GameWorld_1 gameWorld_1) {
        this.gameWorld_1 = gameWorld_1;
    }
    public void processKeyPressed(int keycode){
        switch (keycode) {
            case KeyEvent.VK_A:
                gameWorld_1.megaman.setDirection(MegaMan1.LEFT_DIR);
                gameWorld_1.megaman.run();
                break;
            case KeyEvent.VK_D:
                gameWorld_1.megaman.setDirection(MegaMan1.RIGHT_DIR);
                gameWorld_1.megaman.run();
                break;
            case KeyEvent.VK_W:                
                gameWorld_1.megaman.jump();
                break;  
            case KeyEvent.VK_S:                
                gameWorld_1.megaman.dick();
                break;
            case KeyEvent.VK_SPACE:
                gameWorld_1.megaman.attack();
                break;
            case KeyEvent.VK_L:

                   gameWorld_1.megaman.specialAttack();
                break;

                
            case KeyEvent.VK_ENTER:
                System.out.println("Enter");
                if(gameWorld_1.state==GameWorld_1.INIT_GAME){
                    if(gameWorld_1.previousState==GameWorld_1.GAMEPLAY)
                        gameWorld_1.switchState(GameWorld_1.GAMEPLAY);
                    else gameWorld_1.switchState(GameWorld_1.TUTORIAL);
                }    
                    if(gameWorld_1.state == GameWorld_1.TUTORIAL && gameWorld_1.storyTutorial >= 1){
                    if(gameWorld_1.storyTutorial<=6){
                        gameWorld_1.storyTutorial ++;
                        gameWorld_1.currentSize = 1;
                       gameWorld_1. textTutorial = gameWorld_1.texts1[gameWorld_1.storyTutorial-1];
                    }else{
                        gameWorld_1.switchState(GameWorld_1.GAMEPLAY);
                    }                    
                    // for meeting boss tutorial
                    if(gameWorld_1.tutorialState == GameWorld_1.MEETFINALBOSS){
                        gameWorld_1.switchState(GameWorld_1.GAMEPLAY);
                    }
                }    
                if(gameWorld_1.state==GameWorld_1.GAMEOVER){                   
                    new ManHinh.Menu_game(null, true).setVisible(true);
                    
                }
                if(gameWorld_1.state==GameWorld_1.GAMEWIN){                   
                    new ManHinh.Menu_game(null, true).setVisible(true);
                    
                }
                break;
        }
    }
    public void processKeyReleased(int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_A:
                if(gameWorld_1.megaman.getSpeedX()<0){
                    gameWorld_1.megaman.stopRun();
                }
                break;
            case KeyEvent.VK_S:
                gameWorld_1.megaman.standUp();
                break;
            case KeyEvent.VK_W:
                break;
            case KeyEvent.VK_D:
                if(gameWorld_1.megaman.getSpeedX()>0){
                    gameWorld_1.megaman.stopRun();
                }
                break;
            
        }
    }
    
}
