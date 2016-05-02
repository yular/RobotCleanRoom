package me.interview.tech;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import me.interview.tech.dao.RobotCleanRoomDAOImpl;
import me.interview.tech.domain.Robot;
import me.interview.tech.domain.Room;
import me.interview.tech.service.RobotMoveProcessor;
import me.interview.tech.service.StepIterator;


public class App {
	
    public static void main( String[] args ){
 
    	List<String> inputFiles = new ArrayList<String>();
    	List<String> outputFiles = new ArrayList<String>();
    	int len = args.length;
    	if(len > 0){
    		int id = 0;
    		if(args[id].compareTo("-i") == 0){
    			++ id;
    			for(; id < len; ++ id){
    				if(args[id].compareTo("-o") == 0){
    					break;
    				}
    				inputFiles.add(args[id]);
    			}
    			++ id;
    			if(inputFiles.size() == 0){
    				System.out.println("Please provide input file paths.");
            		return ;
    			}
    			for(; id < len; ++ id){
    				outputFiles.add(args[id]);
    			}
    			
    			if(inputFiles.size() != outputFiles.size()){
    				System.out.println("The number of input files is not equal to the number of output files.");
    				return ;
    			}    			
    			
    			for(int i = 0; i < inputFiles.size(); ++ i){
    				RobotMoveProcessor rmp = new RobotMoveProcessor("Case "+i,inputFiles.get(i),outputFiles.get(i));
    				rmp.start();
    			}
    			
    		}else{
    			System.out.println("Please specify input parameter.");
        		return ;
    		}
    	}else{
    		System.out.println("Please provide input file paths and output file paths.");
    		return ;
    	}
 //       System.out.println( "Hello World!" );
    }
}
