/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import GameObject.*;
import GameObject.*;

public class Camera_1 extends GameObject_1{
    

    private float widthView;
    private float heightView;
    
    private boolean isLocked = false;
    
    public Camera_1(float x, float y, float widthView, float heightView, GameWorld_1 gameWorld) {
        super(x, y, gameWorld);
        this.widthView = widthView;
        this.heightView = heightView;
    }

    public void lock(){
        isLocked = true;
    }
    
    public void unlock(){
        isLocked = false;
    }
    
    @Override
    public void Update() {
    
        // NOTE: WHEN SEE FINAL BOSS, THE CAMERA WON'T CHANGE THE POSITION,
        // AFTER THE TUTORIAL, CAMERA WILL SET THE NEW POS
        
        if(!isLocked){
        
            MegaMan_1 mainCharacter = getGameWorld().megaman;

            if(mainCharacter.getPosX() - getPosX() > 400) setPosX(mainCharacter.getPosX() - 400);
            if(mainCharacter.getPosX() - getPosX() < 200) setPosX(mainCharacter.getPosX() - 200);

            if(mainCharacter.getPosY() - getPosY() > 400) setPosY(mainCharacter.getPosY() - 400); // bottom
            else if(mainCharacter.getPosY() - getPosY() < 250) setPosY(mainCharacter.getPosY() - 250);// top 
        }
    
    }

    public float getWidthView() {
        return widthView;
    }

    public void setWidthView(float widthView) {
        this.widthView = widthView;
    }

    public float getHeightView() {
        return heightView;
    }

    public void setHeightView(float heightView) {
        this.heightView = heightView;
    }
    
}
