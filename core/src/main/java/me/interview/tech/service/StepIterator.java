package me.interview.tech.service;

public class StepIterator {

	//The sequence of steps that the robot will take.
	private String stepSeq;
	//The number of steps that the robot will take.
	private int numSteps;
	//The current index of step sequence string.
	private int stepIdx;
	
	public StepIterator(){
		this.stepSeq = "";
		this.numSteps = 0;
		this.stepIdx = 0;
	}
	
	public StepIterator(String stepSeq){
		this.stepSeq = stepSeq;
		this.numSteps = stepSeq.length();
		this.stepIdx = 0;
	}
	
	public boolean checkStepSeqValid(){
		for(int i = 0; i < numSteps; ++ i){
			if(stepSeq.charAt(i) != 'N' && stepSeq.charAt(i) != 'S' && stepSeq.charAt(i) != 'E' && stepSeq.charAt(i) != 'W')
				return false;
		}
		return true;
	}
	
	public boolean hasNext(){
		return this.stepIdx < this.numSteps;
	}
	
	public char getNext(){
		char res = stepSeq.charAt(stepIdx);
		++ stepIdx;
		return res;
	}
	
	public boolean hasPrev(){
		return this.stepIdx > 0;
	}
	
	public char getPrev(){
		char op = stepSeq.charAt(stepIdx - 1);
		char res = 0;
		switch(op){
			case 'N':res='S';break;
			case 'S':res='N';break;
			case 'E':res='W';break;
			case 'W':res='E';break;
		}
		-- stepIdx;
		return res;
	}
	
	public void setStepSequ(String stepSeq){
		this.stepSeq = stepSeq;
		this.numSteps = stepSeq.length();
	}
	
	public String getStepSequ(){
		return stepSeq;
	}
	
}
