/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import com.mycompany.effect.Animation;
import com.mycompany.effect.CacheDataLoader;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Admin
 */
public class RedEyeBullet  extends  Bullet{
    private Animation forwardBulletAnim,backBulletAnim;

    public RedEyeBullet(float x, float y,  GameWorld gameWorld) {
        super(x, y, 30, 30, 1.0f, 30, gameWorld);
        forwardBulletAnim = CacheDataLoader.getInstance().getAnimation("redeyebullet");
        backBulletAnim = CacheDataLoader.getInstance().getAnimation("redeyebullet");
        backBulletAnim.flipAllImage();
    }
    
    @Override
    public Rectangle getBoundForCollisionWithEnemy() {
            // TODO Auto-generated method stub
            return getBoundForCollisionWithMap();
    }

    @Override
    public void draw(Graphics2D g2) {
            // TODO Auto-generated method stub
        if(getSpeedX() > 0){          
            forwardBulletAnim.Update(System.nanoTime());
            forwardBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }else{
            backBulletAnim.Update(System.nanoTime());
            backBulletAnim.draw((int) (getPosX() - getGameWorld().camera.getPosX()), (int) getPosY() - (int) getGameWorld().camera.getPosY(), g2);
        }
        drawBoundForCollisionWithEnemy(g2);
    }

    @Override
    public void Update() {
            // TODO Auto-generated method stub
        super.Update();
    }

    @Override
    public void attack() {}

    
    
}
