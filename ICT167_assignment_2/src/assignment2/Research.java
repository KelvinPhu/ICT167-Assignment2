package assignment2;

/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Research.java
 * 
 * Purpose: The "Research" class represents research students and holds their specific attributes for research-based 
 * enrollment. It inherits from the "Unit" class, denoting the enrollment type as "R." The class includes 
 * methods to calculate the overall mark and determine the final grade based on the proposal and final 
 * dissertation marks of research students. 
 * 
 * Assumptions/Conditions: include valid integer marks for the proposal and dissertation, and the final grade 
 * calculation assigns letter grades based on defined overall mark ranges (HD, D, C, P, N). The class is 
 * intended to be part of the broader "Student Grade System" to manage and analyze student information for 
 * research-based enrollment.
 * 
 */

public class Research extends Unit {
	private int proposalMark;
    	private int finalDissertationMark;

    	// constructor
    	public Research() {
        	super("R");
    	}
    
    	public Research(String enrolmentType) {
		super(enrolmentType);
		// TODO Auto-generated constructor stub
	}

	public Research(String enrolmentType, int proposalMark, int finalDissertationMark) {
		super(enrolmentType);
		this.proposalMark = proposalMark;
		this.finalDissertationMark = finalDissertationMark;
	}

	// Getters and Setters
    	public int getProposalMark() {
        	return proposalMark;
    	}

    	public void setProposalMark(int proposalMark) {
        	this.proposalMark = proposalMark;
    	}

    	public int getFinalDissertationMark() {
        	return finalDissertationMark;
    	}

    	public void setFinalDissertationMark(int finalDissertationMark) {
        	this.finalDissertationMark = finalDissertationMark;
    	}

    	// Method to calculate overall mark
    	public double overallMark() {
        	return (proposalMark * 0.35) + (finalDissertationMark * 0.65);
    	}

    	// Method to determine the final grade
    	public String finalGrade() {
        	double overallMark = overallMark();
        	if (overallMark >= 80) {
            		return "HD";
        	} else if (overallMark >= 70) {
            		return "D";
        	} else if (overallMark >= 60) {
            		return "C";
        	} else if (overallMark >= 50) {
            		return "P";
        	} else {
            		return "N";
        	}
    	}
	
}
