package me.interview.tech.service;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import me.interview.tech.dao.RobotCleanRoomDAOImpl;
import me.interview.tech.domain.Robot;
import me.interview.tech.domain.Room;


public class RobotMoveProcessor extends Thread{
	
	private Thread t;
	private RobotCleanRoomDAOImpl robotcleandao;
	private String inputFilePath;
	private String outputFilePath;
	private String threadName;
	private Robot robot;
	private Room room;
	private StepIterator stpIt;
	
	public RobotMoveProcessor(){
		threadName = "";
		robotcleandao = new RobotCleanRoomDAOImpl();
		inputFilePath = "";
		outputFilePath = "";
		robot = new Robot();
		room = new Room();
		stpIt = new StepIterator();
	}
	
	public RobotMoveProcessor(String threadName, String inputFilePath, String outputFilePath){
		this.threadName = threadName;
		robotcleandao = new RobotCleanRoomDAOImpl();
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
		robot = new Robot();
		room = new Room();
		stpIt = new StepIterator();
	}
	
	
	public void run(){
		
		try {
			robotcleandao.readFromFile(inputFilePath, robot, room, stpIt);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		
		System.out.println("Processing " +  threadName + " ... "+" Input File Path is :"+inputFilePath+" Output File Path is :"+outputFilePath);
		while(stpIt.hasNext()){
			
			char op = stpIt.getNext();
		//	System.out.println(" op : "+op);
			int posX = robot.getPosX(), posY = robot.getPosY();
			switch(op){
				case 'N':
					++ posY;
					break;
				case 'S':
					-- posY;
					break;
				case 'E':
					++ posX;
					break;
				case 'W':
					-- posX;
					break;
			}
			if(room.checkPositionValid(posY, posX)){
				robot.setPosX(posX);
				robot.setPosY(posY);
			}
			if(room.getGridStatus(robot.getPosY(), robot.getPosX()) == 1){
				room.setGridStatus(robot.getPosY(), robot.getPosX(), 0);
				robot.incrementCntDirtyGrids();
			}
			
		}
//		System.out.println("(x, y) : "+robot.getPosX()+" "+robot.getPosY());
//		System.out.println(" Cnt : "+robot.getCntDirtyGrids());
		
		try {
			robotcleandao.saveToFile(outputFilePath, robot);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(threadName + " Done ... ");
		return ;
	}
	
	public void start(){
		System.out.println("Starting " +  threadName );
		if (t == null){
			t = new Thread (this, threadName);
			t.start ();
		}
	}

}
