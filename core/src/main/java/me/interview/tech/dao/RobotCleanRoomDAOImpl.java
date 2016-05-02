package me.interview.tech.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import me.interview.tech.domain.Robot;
import me.interview.tech.domain.Room;
import me.interview.tech.service.StepIterator;

public class RobotCleanRoomDAOImpl implements RobotCleanRoomDAO{

	public void readFromFile(String filePath, Robot robot, Room room, StepIterator stpIt) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanf = new Scanner(new File(filePath));
		int numCols = scanf.nextInt(), numRows = scanf.nextInt();
		room.setNumRows(numRows);
		room.setNumCols(numCols);
		robot.setPosX(scanf.nextInt());
		robot.setPosY(scanf.nextInt());
		while(scanf.hasNextInt()){
			int posY = scanf.nextInt(), posX = scanf.nextInt();
			room.setGridStatus(posY, posX, 1);
		}
		stpIt.setStepSequ(scanf.next());
		scanf.close();
	}

	public void saveToFile(String filePath, Robot robot) throws FileNotFoundException {
		// TODO Auto-generated method stub
		PrintWriter pw = new PrintWriter(new File(filePath));
		pw.println(robot.getPosX()+" "+robot.getPosY());
		pw.println(robot.getCntDirtyGrids());
		pw.flush();
		pw.close();
	}

}
