/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

/**
 *
 * @author Admin
 */
public abstract class GameObject {

	private float posX;
	private float posY;
	
	private GameWorld gameWorld;
	
	public GameObject(float x, float y, GameWorld gameWorld){
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
	
	public GameWorld getGameWorld(){
		return gameWorld;
	}
	
	public abstract void Update();
	
}
