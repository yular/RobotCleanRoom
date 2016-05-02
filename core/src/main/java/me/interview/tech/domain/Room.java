package me.interview.tech.domain;

public class Room {

	//The number of rows and columns of grids of the room.
	private int numRows, numCols;
	//The grids room. 0 means the grid is empty. 1 means the grid is dirty.
	//2 means the grid is occupied by the robot.
	private int[][] grid;
	
	//By default, the grids consist of 10 rows and 10 columns . 
	public Room(){
		this.numRows = 10;
		this.numCols = 10;
		grid = new int[this.numRows][this.numCols];
	}
	
	public Room(int rows, int cols){
		this.numRows = rows;
		this.numCols = cols;
		grid = new int[this.numRows][this.numCols];
	}
	
	public int getNumRows(){
		return numRows;
	}
	
	public int getNumCols(){
		return numCols;
	}
	
	public void setNumRows(int numRows){
		this.numRows = numRows;
	}
	
	public void setNumCols(int numCols){
		this.numCols = numCols;
	}
	
	public void setGridStatus(int r, int c, int status){
		this.grid[r][c] = status;
	}
	
	public int getGridStatus(int r, int c){
		return grid[r][c];
	}
	
	public boolean checkPositionValid(int r, int c){
		return r >= 0 && r < numRows && c >= 0 && c < numCols;
	}
	
}
