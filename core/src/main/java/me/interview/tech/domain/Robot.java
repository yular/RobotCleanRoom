package me.interview.tech.domain;

//The Robot class represents in the game.
public class Robot {

	//Current Position of Robot
	private int posX, posY;
	//The number of dirty grids cleaned by the robot
	private int cntDirtyGrids;
	
	public Robot(){
		this.cntDirtyGrids = 0;
	}
	
	public Robot(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void setPosX(int posX){
		this.posX = posX;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}
	
	public int getCntDirtyGrids(){
		return cntDirtyGrids;
	}
	
	public void incrementCntDirtyGrids(){
		++ this.cntDirtyGrids;
	}
	
	public void setCntDirtyGrids(int cnt){
		this.cntDirtyGrids = cnt;
	}
}
