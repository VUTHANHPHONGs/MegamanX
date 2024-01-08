/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import GameObject.*;
import GameObject.*;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
//quanlitatcaObject
public class ParticularObjectManager_1 {
    //dua_tat_ca_object_vao_list
    public List<ParticularObject_1> particularObjects;

    private GameWorld_1 gameWorld;
    
    public ParticularObjectManager_1(GameWorld_1 gameWorld){
        //Dong_bo_hoa_list_khi_nhieu_luong_truy_cap
        particularObjects = Collections.synchronizedList(new LinkedList<ParticularObject_1>());
        this.gameWorld = gameWorld;
        
    }
    
    public GameWorld_1 getGameWorld(){
        return gameWorld;
    }
    
    public void addObject(ParticularObject_1 particularObject){
        
        
        synchronized(particularObjects){
            particularObjects.add(particularObject);
        }
        
    }
    
    public void RemoveObject(ParticularObject_1 particularObject){
        synchronized(particularObjects){
        
            for(int id = 0; id < particularObjects.size(); id++){
                
                ParticularObject_1 object = particularObjects.get(id);
                if(object == particularObject)
                    particularObjects.remove(id);

            }
        }
    }
    
    public ParticularObject_1 getCollisionWidthEnemyObject(ParticularObject_1 object){
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){
                
                ParticularObject_1 objectInList = particularObjects.get(id);

                if(object.getTeamType() != objectInList.getTeamType() && 
                        object.getBoundForCollisionWithEnemy().intersects(objectInList.getBoundForCollisionWithEnemy())){
                    return objectInList;
                }
            }
        }
        return null;
    }
    
    public void UpdateObjects(){
        
        synchronized(particularObjects){
            for(int id = 0; id < particularObjects.size(); id++){
                
                ParticularObject_1 object = particularObjects.get(id);
                
                
                if(!object.isObjectOutOfCameraView()) object.Update();
                
                if(object.getState() == ParticularObject_1.DEATH){
                    particularObjects.remove(id);
                }
            }
        }

        //System.out.println("Camerawidth  = "+camera.getWidth());
        
    }
    
    public void draw(Graphics2D g2){
        synchronized(particularObjects){
            for(ParticularObject_1 object: particularObjects)
                if(!object.isObjectOutOfCameraView()) object.draw(g2);
        }
    }
}
