/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import GameObject.*;
import GameObject.*;
import com.mycompany.effect.CacheDataLoader;
import com.mycompany.effect.FrameImage;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Admin
 */
public class GameWorld_1 {
    public MegaMan_1 megaman ;
    public Camera_1 camera ;
    public PhysicalMap_1 physicalMap;
    public BulletManager_1 bulletManager;
    public BackgroundMap_1 backgroundMap;
    public AudioClip bgMusic;
    private BufferedImage bufferedImage;
    private int lastState;
    
    
    
    public static final int finalBossX=3600;
    
    public static final int INIT_GAME = 0;
    public static final int TUTORIAL = 1;
    public static final int GAMEPLAY = 2;
    public static final int GAMEOVER = 3;
    public static final int GAMEWIN = 4;
    public static final int PAUSEGAME = 5;
    public static final int FULLPOWER = 6;
    public static final int NONE = 6;
    
    
    public static final int INTROGAME = 0;
    public static final int MEETFINALBOSS = 1;
    
    public int openIntroGameY = 0;
    public int state = INIT_GAME;
    
    public int previousState = state;
    public int tutorialState = INTROGAME;
    //
    public int storyTutorial = 0;
    public String[] texts1 = new String[7];
    
    public int state1 =NONE ;
    
    public String textTutorial;
    public int currentSize = 1;
    
    private boolean finalbossTrigger = true;
    ParticularObject_1 boss;
    //
    public String[] texts11 = new String[7];
    public int storyTutorial1 = 0;
    public String textTutoria1l;
    public int currentSize1 = 1;
    
    FrameImage avatar = CacheDataLoader.getInstance().getFrameImage("avatar");
    FrameImage talk=CacheDataLoader.getInstance().getFrameImage("talk");
    FrameImage thomas=CacheDataLoader.getInstance().getFrameImage("thomas");
    
    
    private int numberOfLife = 3;
    
    public ParticularObjectManager_1 particularObjectManager;
    public  GameWorld_1(){
        
        texts1[0] = "Doctor, I heard he has returned to destroy our city ! \n" +
"and his power is terrible along with the large number of monsters.";
        texts1[1] = "What should I do now, Dr. Thomas . . . .?";
        texts1[2] = "Go to the city and help those in need !\nNow is the time for us, kill it and get freedom . !....";
        texts1[3] = "I will add someone to help you. They will come soon. . . . .!";
        texts1[4] = "Really doctor, I will destroy all of you, just wait . . . .  ! ! !"  ;    
        texts1[5] = "      LET'S GO!.....";
        texts1[6] = "      GOOD LUCK !.....";
        
        
        
        
        
        textTutorial = texts1[0];


        bufferedImage = new BufferedImage(GameFrame_Single_mode.SCREEN_WIDTH, GameFrame_Single_mode.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        megaman = new MegaMan_1(300, 300, this);
        megaman.setTeamType(ParticularObject.LEAGUE_TEAM);
        physicalMap = new PhysicalMap_1(0, 0,this);
        backgroundMap = new BackgroundMap_1(0, 0, this);
        camera = new Camera_1(0, 0, GameFrame_Single_mode.SCREEN_WIDTH, GameFrame_Single_mode.SCREEN_HEIGHT, this);
        bulletManager = new BulletManager_1(this);
        particularObjectManager = new ParticularObjectManager_1(this);
       particularObjectManager.addObject(megaman);
       initEnemies();
       bgMusic= CacheDataLoader.getInstance().getSound("bgmusic");
    }
    private void initEnemies(){
        ParticularObject_1 redeye = new RedEyeDevil_1(1250, 410, this);
        redeye.setDirection(ParticularObject.LEFT_DIR);
        redeye.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(redeye);
        
        ParticularObject_1 redeye2 = new RedEyeDevil_1(2500, 500, this);
        redeye2.setDirection(ParticularObject.LEFT_DIR);
        redeye2.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(redeye2);
        
        ParticularObject_1 redeye3 = new RedEyeDevil_1(3450, 500, this);
        redeye3.setDirection(ParticularObject.LEFT_DIR);
        redeye3.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(redeye3);
        
        ParticularObject_1 redeye4 = new RedEyeDevil_1(500, 1190, this);
        redeye4.setDirection(ParticularObject.RIGHT_DIR);
        redeye4.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(redeye4);
        
        
        
        ParticularObject_1 robotR = new RobotR_1(900, 400, this);
        robotR.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(robotR);
        
        ParticularObject_1 robotR2 = new RobotR_1(3400, 350, this);
        robotR2.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(robotR2);
        
        ParticularObject_1 robotR3 = new RobotR_1(1500, 1150, this);
        robotR3.setTeamType(ParticularObject.ENEMY_TEAM);
        particularObjectManager.addObject(robotR3);
        
        boss = new FinalBoss_1(finalBossX + 700, 460, this);
        boss.setTeamType(ParticularObject.ENEMY_TEAM);
        boss.setDirection(ParticularObject.LEFT_DIR);
        particularObjectManager.addObject(boss);
        
        
        

    }
    
     public void switchState(int state){
        previousState = this.state;
        this.state = state;
    }
    
     
     private void TutorialUpdate(){
        switch(tutorialState){
            case INTROGAME:
                
                if(storyTutorial == 0){
                    if(openIntroGameY < 450) {
                        openIntroGameY+=4;
                    }else storyTutorial ++;
                    
                }else{
                    if(currentSize < textTutorial.length()) currentSize++;
                }
               
                break;
            case MEETFINALBOSS:
                break;
        }
    }    
     private void drawString(Graphics2D g2, String text, int x, int y){
        for(String str : text.split("\n"))
            g2.drawString(str, x, y+=g2.getFontMetrics().getHeight());
    }
     
     private void TutorialRender(Graphics2D g2){
        switch(tutorialState){            
            case INTROGAME:
                int yMid = GameFrame_Single_mode.SCREEN_HEIGHT/2 - 15;
                int y1 = yMid - GameFrame_Single_mode.SCREEN_HEIGHT/2 - openIntroGameY/2;
                int y2 = yMid + openIntroGameY/2;
                g2.drawImage(talk.getImage(), 0, 0, null);
                g2.setColor(Color.BLACK);
                g2.fillRect(0, y1, GameFrame_Single_mode.SCREEN_WIDTH, GameFrame_Single_mode.SCREEN_HEIGHT/2);
                g2.fillRect(0, y2, GameFrame_Single_mode.SCREEN_WIDTH, GameFrame_Single_mode.SCREEN_HEIGHT/2);
                
                if(storyTutorial >= 1 && storyTutorial<3){
                    g2.drawImage(avatar.getImage(), 700, 350, null);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(200, 450, 500, 80);
                    g2.setColor(Color.WHITE);
                    g2.drawRect(200, 450, 500, 80);
                    String textName="MegaMan:";
                    drawString(g2,textName,220,452);
                    String text = textTutorial.substring(0, currentSize - 1);
                    drawString(g2, text, 250, 470);
                } 
                if(storyTutorial >= 3 && storyTutorial<=4){
                    g2.drawImage(thomas.getImage(), 0, 350, null);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(280, 450, 500, 80);
                    g2.setColor(Color.WHITE);
                    g2.drawRect(280, 450, 500, 80);
                    String textName="Doctor Thomas:";
                    drawString(g2,textName,300,452);
                    String text = textTutorial.substring(0, currentSize - 1);
                    drawString(g2, text, 320, 480);
                }
                if(storyTutorial >= 5 && storyTutorial<=6){
                    g2.drawImage(avatar.getImage(), 700, 350, null);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(200, 450, 500, 80);
                    g2.setColor(Color.WHITE);
                    g2.drawRect(200, 450, 500, 80);
                    String textName="MegaMan:";
                    drawString(g2,textName,220,452);
                    String text = textTutorial.substring(0, currentSize - 1);
                    drawString(g2, text, 250, 480);
                }
                if(storyTutorial==7){
                    g2.drawImage(thomas.getImage(), 0, 350, null);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(280, 450, 500, 80);
                    g2.setColor(Color.WHITE);
                    g2.drawRect(280, 450, 500, 80);
                    String textName="Doctor Thomas:";
                    drawString(g2,textName,300,452);
                    String text = textTutorial.substring(0, currentSize - 1);
                    drawString(g2, text, 320, 480);
                }
                break;
            case MEETFINALBOSS:
                break;
                
        }
    }
    public BufferedImage getBufferedImage(){
        return bufferedImage;
    }
    public static boolean check=true;
    public void Update(){

        switch (state) {
            case INIT_GAME:
                break;
            case TUTORIAL:
                TutorialUpdate();
                break;
            case GAMEPLAY:
                if(camera.getPosX() >= finalBossX && megaman.getPosX() >= finalBossX + 200){
                    camera.lock();
                    check=false;
                    physicalMap.phys_map[14][120] = 1;
                        physicalMap.phys_map[15][120] = 1;
                        physicalMap.phys_map[16][120] = 1;
                        physicalMap.phys_map[17][120] = 1;
                        
                        backgroundMap.map[14][120] = 17;
                        backgroundMap.map[15][120] = 17;
                        backgroundMap.map[16][120] = 17;
                        backgroundMap.map[17][120] = 17;
                }
                
                particularObjectManager.UpdateObjects();
                bulletManager.UpdateObjects();
        
                physicalMap.Update();
                camera.Update();
            case GAMEOVER:
                break;
            case GAMEWIN:
                break;
        }
    }
    public static int n;//setmauhientai
    public static int k=0;
    public static int temp=75;
    public void Render(Graphics2D g2){
        
        switch (state) {
            case GAMEWIN:                            
                break;
            case INIT_GAME:
                g2.setColor(Color.BLACK);
                    g2.fillRect(0, 0, GameFrame_Single_mode.SCREEN_WIDTH, GameFrame_Single_mode.SCREEN_HEIGHT);
                    g2.setColor(Color.WHITE);
                    g2.drawString("PRESS ENTER TO CONTINUE", 400, 300);
                    break;
            case PAUSEGAME:
                g2.setColor(Color.BLACK);
                    g2.fillRect(300, 260, 500, 70);
                    g2.setColor(Color.WHITE);
                    g2.drawString("PRESS ENTER TO CONTINUE", 400, 300);
                    break;
            
            case TUTORIAL:

                    if(tutorialState == MEETFINALBOSS){
                        particularObjectManager.draw(g2);
                    }
                    TutorialRender(g2);
                    
                    break;
                
            case GAMEPLAY:
                backgroundMap.draw(g2);

                for(int i=0;i<numberOfLife;i++){
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("hearth").getImage(), 20 + i*40, 18, null);            
                }
                
                g2.drawImage(CacheDataLoader.getInstance().getFrameImage("logoingame").getImage(), 17,50, null);
                g2.drawImage(CacheDataLoader.getInstance().getFrameImage("buttom").getImage(), 700, 450,null);
                
                //set_Blood.
                particularObjectManager.draw(g2);
                bulletManager.draw(g2);
                n=megaman.getBlood();
                k=200-n;                
                g2.setColor(Color.black);
                g2.fillRect(54, 59, 200, 6);
                g2.setColor(Color.green);
                g2.fillRect(54, 59, n,6);
                g2.setColor(Color.white);
                g2.drawRect(54, 59, 200,6);
                //set_Exp
                g2.setColor(Color.black);
                g2.fillRect(54, 70, 150, 6);
                g2.setColor(Color.yellow);
                g2.fillRect(54, 70,75, 6);
                g2.setColor(Color.yellow);
                if(k<=75){
                    g2.fillRect(129, 70,75-(75-k), 6);
                    
                }
                else{
                 
                    g2.fillRect(129, 70, 75, 6);
                }
                
 
                g2.setColor(Color.white);
                g2.drawRect(54, 70, 150, 6);   
                if(!check){ 
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("fnboss").getImage(), 940, 50,null);
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("buttom").getImage(), 700, 420,null);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(0, 0, GameFrame_Single_mode.SCREEN_WIDTH, 50);
                    g2.fillRect(0, 500, GameFrame_Single_mode.SCREEN_WIDTH, 100);
                    g2.setColor(Color.BLACK);
                    g2.fillRect(690, 60, 250, 12);
                    g2.setColor(Color.RED);
                    g2.fillRect(690, 60, boss.getBlood()/2, 12);
                    g2.setColor(Color.WHITE);
                    g2.drawRect(690, 60, 250, 12);
    
                }
                if(boss.getBlood()==0){
                    
                    g2.drawImage(CacheDataLoader.getInstance().getFrameImage("gamewin").getImage(), 300, 200, null);
                    megaman.stopRun();
                    switchState(GAMEWIN);
                    check=true;
                }
                if(megaman.getState() == ParticularObject.DEATH){
                    numberOfLife --;
                    if(numberOfLife >= 0){
                        megaman.setBlood(200);
                        megaman.setPosY(megaman.getPosY() - 50);
                        megaman.setState(ParticularObject.NOBEHURT);
                        particularObjectManager.addObject(megaman);
                    }else{
                        switchState(GAMEOVER);
//                        bgMusic.stop();
                    }
                }
                
            break;     
            case GAMEOVER:
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, GameFrame_Single_mode.SCREEN_WIDTH, GameFrame_Single_mode.SCREEN_HEIGHT);
                g2.setColor(Color.WHITE);
                Font font = new Font("UMT Nokia", Font.BOLD, 20);
                g2.setFont(font);
                g2.drawString("GAME OVER!", 450, 300);
                break;
                
        }

        
        
        
        
    }
    
}
