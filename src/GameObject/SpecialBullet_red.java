/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import static GameObject.ParticularObject.ALIVE;
import static GameObject.ParticularObject.BEHURT;
import com.mycompany.effect.Animation;
import com.mycompany.effect.CacheDataLoader;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public class SpecialBullet_red extends Bullet{
    private Animation forwardBulletAnim,backBulletAnim;

    public SpecialBullet_red(float x, float y, GameWorld gameWorld) {
        super(x, y, 60, 30, 1.0f, 100, gameWorld);
        forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("dandacbiet1");
        backBulletAnim = CacheDataLoader.getInstance().getAnimation("dandacbiet1");
        //dao_nguoc_animation
        backBulletAnim.flipAllImage();
    }
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
       
        return getBoundForCollisionWithMap();
    }
    @Override
    public void draw(Graphics2D g2) {
            
        if(getSpeedX() > 0){
            if(!forwardBulletAnim.isIgnoreFrame(0) && forwardBulletAnim.getCurrentFrame() == 3){
                //3_frame_dau_tien khong di chuyen
                forwardBulletAnim.setIgnoreFrame(0);
                forwardBulletAnim.setIgnoreFrame(1);
                forwardBulletAnim.setIgnoreFrame(2);
            }
                
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }else{
            if(!backBulletAnim.isIgnoreFrame(0) && backBulletAnim.getCurrentFrame() == 3){
                backBulletAnim.setIgnoreFrame(0);
                backBulletAnim.setIgnoreFrame(1);
                backBulletAnim.setIgnoreFrame(2);
            }
            backBulletAnim.Update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }
        //drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void Update() {
           
            
        if(forwardBulletAnim.isIgnoreFrame(0) || backBulletAnim.isIgnoreFrame(0))
            setPosX(getPosX() + getSpeedX());
        ParticularObject object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
        if(object!=null && object.getState() == ALIVE){
            setBlood(0);
            object.setBlood(object.getBlood() - getDamage());
            object.setState(BEHURT);
            System.out.println("Bullet set behurt for enemy");
        }
    }
    
    @Override
    public void attack() {}
    
}
