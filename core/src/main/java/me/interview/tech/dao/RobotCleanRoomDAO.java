package me.interview.tech.dao;

import java.io.FileNotFoundException;

import me.interview.tech.domain.Robot;
import me.interview.tech.domain.Room;
import me.interview.tech.service.StepIterator;

public interface RobotCleanRoomDAO {

	//Read input from given file
	public void readFromFile(String filePath, Robot robot, Room room, StepIterator stpIt) throws FileNotFoundException;
	//Save output to given file
	public void saveToFile(String filePath, Robot robot) throws FileNotFoundException;
	
}
