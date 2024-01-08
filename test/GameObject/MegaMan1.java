///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
// */
package GameObject;



import GameObject.BlueFire;
import GameObject.Bullet;
import GameObject.GameWorld;
import GameObject.Human;
import static GameObject.ParticularObject.ALIVE;
import static GameObject.ParticularObject.BEHURT;
import static GameObject.ParticularObject.FEY;
import static GameObject.ParticularObject.LEAGUE_TEAM;
import static GameObject.ParticularObject.LEFT_DIR;
import static GameObject.ParticularObject.NOBEHURT;
import static GameObject.ParticularObject.RIGHT_DIR;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.mycompany.effect.Animation;

import com.mycompany.effect.Animation;

import com.mycompany.effect.Animation;
import com.mycompany.effect.CacheDataLoader;

public class MegaMan1 extends Human {

    public static final int RUNSPEED = 3;
    
    private Animation runForwardAnim, runBackAnim, runShootingForwarAnim, runShootingBackAnim;
    private Animation idleForwardAnim, idleBackAnim, idleShootingForwardAnim, idleShootingBackAnim;
    private Animation dickForwardAnim, dickBackAnim;
    private Animation flyForwardAnim, flyBackAnim, flyShootingForwardAnim, flyShootingBackAnim;
    private Animation landingForwardAnim, landingBackAnim;
    
    private Animation climWallForward, climWallBack;
    
    private long lastShootingTime;
    private boolean isShooting = false;
    
    private AudioClip hurtingSound;
    private AudioClip shooting1;
    
    public MegaMan1(float x, float y, GameWorld gameWorld) {
        super(x, y, 70, 90, 0.12f, 200, gameWorld);
        
        shooting1 = CacheDataLoader.getInstance().getSound("bluefireshooting");
        hurtingSound = CacheDataLoader.getInstance().getSound("megamanhurt");
        
        setTeamType(LEAGUE_TEAM);

        setTimeForNoBehurt(2000*1000000);
        
        runForwardAnim = CacheDataLoader.getInstance().getAnimation("run_cr2");
        runBackAnim = CacheDataLoader.getInstance().getAnimation("run_cr2");
        runBackAnim.flipAllImage();   
        
        idleForwardAnim = CacheDataLoader.getInstance().getAnimation("idle_cr2");
        idleBackAnim = CacheDataLoader.getInstance().getAnimation("idle_cr2");
        idleBackAnim.flipAllImage();
        
        dickForwardAnim = CacheDataLoader.getInstance().getAnimation("dick_cr2");
        dickBackAnim = CacheDataLoader.getInstance().getAnimation("dick_cr2");
        dickBackAnim.flipAllImage();
        
        flyForwardAnim = CacheDataLoader.getInstance().getAnimation("flyingup_cr2");
        flyForwardAnim.setIsRepeated(false);
        flyBackAnim = CacheDataLoader.getInstance().getAnimation("flyingup_cr2");
        flyBackAnim.setIsRepeated(false);
        flyBackAnim.flipAllImage();
        
        landingForwardAnim = CacheDataLoader.getInstance().getAnimation("landing_cr2");
        landingBackAnim = CacheDataLoader.getInstance().getAnimation("landing_cr2");
        landingBackAnim.flipAllImage();
        
        climWallBack = CacheDataLoader.getInstance().getAnimation("clim_wall");
        climWallForward = CacheDataLoader.getInstance().getAnimation("clim_wall");
        climWallForward.flipAllImage();
        
        behurtForwardAnim = CacheDataLoader.getInstance().getAnimation("hurting_cr2");
        behurtBackAnim = CacheDataLoader.getInstance().getAnimation("hurting_cr2");
        behurtBackAnim.flipAllImage();
        
        idleShootingForwardAnim = CacheDataLoader.getInstance().getAnimation("idleshoot_cr2");
        idleShootingBackAnim = CacheDataLoader.getInstance().getAnimation("idleshoot_cr2");
        idleShootingBackAnim.flipAllImage();
        
        runShootingForwarAnim = CacheDataLoader.getInstance().getAnimation("run_cr2");
        runShootingBackAnim = CacheDataLoader.getInstance().getAnimation("run_cr2");
        runShootingBackAnim.flipAllImage();
        
        flyShootingForwardAnim = CacheDataLoader.getInstance().getAnimation("flyingupshoot_cr2");
        flyShootingBackAnim = CacheDataLoader.getInstance().getAnimation("flyingupshoot_cr2");
        flyShootingBackAnim.flipAllImage();
        
    }

    @Override
    public void Update() {

        super.Update();
        
        if(isShooting){
            if(System.nanoTime() - lastShootingTime > 500*1000000){
                isShooting = false;
            }
        }
        
        if(getIsLanding()){
            landingBackAnim.Update(System.nanoTime());
            if(landingBackAnim.isLastFrame()) {
                setIsLanding(false);
                landingBackAnim.reset();
                runForwardAnim.reset();
                runBackAnim.reset();
            }
        }
        
    }

    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
        // TODO Auto-generated method stub
        Rectangle rect = getBoundForCollisionWithMap();
        
        if(getIsDicking()){
            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 20;
            rect.width = 44;
            rect.height = 65;
        }else{
            rect.x = (int) getPosX() - 22;
            rect.y = (int) getPosY() - 40;
            rect.width = 44;
            rect.height = 80;
        }
        
        return rect;
    }

    @Override
    public void draw(Graphics2D g2) {
        
        switch(getState()){
        
            case ALIVE:
            case NOBEHURT:
                if(getState() == NOBEHURT && (System.nanoTime()/10000000)%2!=1)
                {
                    System.out.println("Plash...");
                }else{
                    
                    if(getIsLanding()){

                        if(getDirection() == RIGHT_DIR){
                            landingForwardAnim.setCurrentFrame(landingBackAnim.getCurrentFrame());
                            landingForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), 
                                    (int) getPosY() - (int) getGameWorld().camera.getPosY() + (getBoundForCollisionWithMap().height/2 - landingForwardAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }else{
                            landingBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), 
                                    (int) getPosY() - (int) getGameWorld().camera.getPosY() + (getBoundForCollisionWithMap().height/2 - landingBackAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }

                    }else if(getIsJumping()){

                        if(getDirection() == RIGHT_DIR){
                            flyForwardAnim.Update(System.nanoTime());
                            if(isShooting){
                                flyShootingForwardAnim.setCurrentFrame(flyForwardAnim.getCurrentFrame());
                                flyShootingForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()) + 10, (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                            }else
                                flyForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                        }else{
                            flyBackAnim.Update(System.nanoTime());
                            if(isShooting){
                                flyShootingBackAnim.setCurrentFrame(flyBackAnim.getCurrentFrame());
                                flyShootingBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()) - 10, (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                            }else
                            flyBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                        }

                    }else if(getIsDicking()){

                        if(getDirection() == RIGHT_DIR){
                            dickForwardAnim.Update(System.nanoTime());
                            dickForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), 
                                    (int) getPosY() - (int) getGameWorld().camera.getPosY() + (getBoundForCollisionWithMap().height/2 - dickForwardAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }else{
                            dickBackAnim.Update(System.nanoTime());
                            dickBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), 
                                    (int) getPosY() - (int) getGameWorld().camera.getPosY() + (getBoundForCollisionWithMap().height/2 - dickBackAnim.getCurrentImage().getHeight()/2),
                                    g2);
                        }

                    }else{
                        if(getSpeedX() > 0){
                            runForwardAnim.Update(System.nanoTime());
                            if(isShooting){
                                runShootingForwarAnim.setCurrentFrame(runForwardAnim.getCurrentFrame() - 1);
                                runShootingForwarAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                            }else
                                runForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                            if(runForwardAnim.getCurrentFrame() == 1) runForwardAnim.setIgnoreFrame(0);
                        }else if(getSpeedX() < 0){
                            runBackAnim.Update(System.nanoTime());
                            if(isShooting){
                                runShootingBackAnim.setCurrentFrame(runBackAnim.getCurrentFrame() - 1);
                                runShootingBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                            }else
                                runBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                            if(runBackAnim.getCurrentFrame() == 1) runBackAnim.setIgnoreFrame(0);
                        }else{
                            if(getDirection() == RIGHT_DIR){
                                if(isShooting){
                                    idleShootingForwardAnim.Update(System.nanoTime());
                                    idleShootingForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                                }else{
                                    idleForwardAnim.Update(System.nanoTime());
                                    idleForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                                }
                            }else{
                                if(isShooting){
                                    idleShootingBackAnim.Update(System.nanoTime());
                                    idleShootingBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                                }else{
                                    idleBackAnim.Update(System.nanoTime());
                                    idleBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                                }
                            }
                        }            
                    }
                }
                
                break;
            
            case BEHURT:
                if(getDirection() == RIGHT_DIR){
                    behurtForwardAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                }else{
                    behurtBackAnim.setCurrentFrame(behurtForwardAnim.getCurrentFrame());
                    behurtBackAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
                }
                break;
             
            case FEY:
                
                break;

        }
        
        drawBoundForCollisionWithMap(g2);
        drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void run() {
        if(getDirection() == LEFT_DIR)
            setSpeedX(-4);
        else setSpeedX(4);
    }

    @Override
    public void jump() {

        if(!getIsJumping()){
            setIsJumping(true);
            setSpeedY(-5.0f);           
            flyBackAnim.reset();
            flyForwardAnim.reset();
        }
        // for clim wall
        else{
            Rectangle rectRightWall = getBoundForCollisionWithMap();
            rectRightWall.x += 1;
            Rectangle rectLeftWall = getBoundForCollisionWithMap();
            rectLeftWall.x -= 1;
            
            if(getGameWorld().physicalMap.haveCollisionWithRightWall(rectRightWall)!=null && getSpeedX() > 0){
                setSpeedY(-5.0f);
                //setSpeedX(-1);
                flyBackAnim.reset();
                flyForwardAnim.reset();
                //setDirection(LEFT_DIR);
            }else if(getGameWorld().physicalMap.haveCollisionWithLeftWall(rectLeftWall)!=null && getSpeedX() < 0){
                setSpeedY(-5.0f);
                //setSpeedX(1);
                flyBackAnim.reset();
                flyForwardAnim.reset();
                //setDirection(RIGHT_DIR);
            }
                
        }
    }

    @Override
    public void dick() {
        if(!getIsJumping())
            setIsDicking(true);
    }

    @Override
    public void standUp() {
        setIsDicking(false);
        idleForwardAnim.reset();
        idleBackAnim.reset();
        dickForwardAnim.reset();
        dickBackAnim.reset();
    }

    @Override
    public void stopRun() {
        setSpeedX(0);
        runForwardAnim.reset();
        runBackAnim.reset();
        runForwardAnim.unIgnoreFrame(0);
        runBackAnim.unIgnoreFrame(0);
    }
    public void specialAttack(){
        if(!isShooting && !getIsDicking()){
            
            shooting1.play();
            
            Bullet bullet = new SpecialBullet_red(getPosX(), getPosY(), getGameWorld());
            if(getDirection() == LEFT_DIR) {
                bullet.setSpeedX(-10);
                bullet.setPosX(bullet.getPosX() - 40);
                if(getSpeedX() != 0 && getSpeedY() == 0){
                    //truong hop dang chay ban sung
                    bullet.setPosX(bullet.getPosX() - 10);
                    bullet.setPosY(bullet.getPosY() - 5);
                }
            }else {
                bullet.setSpeedX(10);
                bullet.setPosX(bullet.getPosX() + 40);
                if(getSpeedX() != 0 && getSpeedY() == 0){
                    bullet.setPosX(bullet.getPosX() + 10);
                    bullet.setPosY(bullet.getPosY() - 5);
                }
            }
            if(getIsJumping())
                //set_vi_tri_cho_dung_sung
                bullet.setPosY(bullet.getPosY() - 20);
            //cung_team_khong_tinh)sat_thuong
            bullet.setTeamType(getTeamType());
            getGameWorld().bulletManager.addObject(bullet);
            lastShootingTime = System.nanoTime();
            isShooting = true;
            
        }
    
    }
    @Override
    public void attack() {
        //khongban_va_k_ngoi
        if(!isShooting && !getIsDicking()){
            
            shooting1.play();
            
            Bullet bullet = new BlueFire(getPosX(), getPosY(), getGameWorld());
            if(getDirection() == LEFT_DIR) {
                bullet.setSpeedX(-10);
                bullet.setPosX(bullet.getPosX() - 40);
                if(getSpeedX() != 0 && getSpeedY() == 0){
                    //truong hop dang chay ban sung
                    bullet.setPosX(bullet.getPosX() - 10);
                    bullet.setPosY(bullet.getPosY() - 5);
                }
            }else {
                bullet.setSpeedX(10);
                bullet.setPosX(bullet.getPosX() + 40);
                if(getSpeedX() != 0 && getSpeedY() == 0){
                    bullet.setPosX(bullet.getPosX() + 10);
                    bullet.setPosY(bullet.getPosY() - 5);
                }
            }
            if(getIsJumping())
                //set_vi_tri_cho_dung_sung
                bullet.setPosY(bullet.getPosY() - 20);
            //cung_team_khong_tinh)sat_thuong
            bullet.setTeamType(getTeamType());
            getGameWorld().bulletManager.addObject(bullet);
            lastShootingTime = System.nanoTime();
            isShooting = true;
            
        }
    
    }
   
    @Override
    public void hurtingCallback(){
        
        System.out.println("Call back hurting");
        hurtingSound.play();
    }

}