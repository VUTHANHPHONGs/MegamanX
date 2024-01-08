/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Single_Player_Mode;

import GameObject.*;
import GameObject.*;

/**
 *
 * @author Admin
 */
public abstract class GameObject_1 {

	private float posX;
	private float posY;
	
	private GameWorld_1 gameWorld;
	
	public GameObject_1(float x, float y, GameWorld_1 gameWorld){
		posX = x;
		posY = y;
		this.gameWorld = gameWorld;
	}
	
	public void setPosX(float x){
		posX = x;
	}
	
	public float getPosX(){
		return posX;
	}
	
	public void setPosY(float y){
		posY = y;
	}
	
	public float getPosY(){
		return posY;
	}
	
	public GameWorld_1 getGameWorld(){
		return gameWorld;
	}
	
	public abstract void Update();
	
}
