/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import GameObject.*;
import GameObject.*;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public abstract class Bullet_1 extends ParticularObject_1{
    
    public Bullet_1(float x, float y, float width, float height, float mass, int damage, GameWorld_1 gameWorld) {
        super(x, y, width, height, mass,1, gameWorld);
        setDamage(damage);
    }
    
    public abstract void draw(Graphics2D g2);
    
    public void Update(){
         super.Update();
            setPosX(getPosX()+getSpeedX());
            setPosY(getPosY()+getSpeedY());
            ParticularObject_1 object = getGameWorld().particularObjectManager.getCollisionWidthEnemyObject(this);
          if(object!=null && object.getState() == ALIVE){
            setBlood(0);
            object.beHurt(getDamage());
            System.out.println("Bullet set behurt for enemy");
          }
    }
            
}   
    

