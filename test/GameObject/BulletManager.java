/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

/**
 *
 * @author Admin
 */
public class BulletManager  extends ParticularObjectManager{
    
    public BulletManager(GameWorld gameWorld) {
        super(gameWorld);
    }
    @Override
    public void UpdateObjects(){
        super.UpdateObjects();
        synchronized (particularObjects) {
            //kiem tra doi tuong out khoi man hinh
            for(int id=0;id<particularObjects.size();id++){
                ParticularObject object = particularObjects.get(id);
                if(!object.isObjectOutOfCameraView()) object.Update();
                if(object.isObjectOutOfCameraView() || object.getState() == ParticularObject.DEATH){
                    particularObjects.remove(id);
                }
            }
        }
        
    }
    
}
