package assignment2;

/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Unit_Course.java
 * 
 * Purpose: The "Unit_Course" class extends the "Unit" class and represents a course work unit in the student 
 * grade system. It contains attributes related to the course, such as the unit ID, level, and marks for 
 * assignments and the final exam. Additionally, it includes a reference field "student" to associate the unit
 * with a specific student who is enrolled in the course. The class provides constructors to create instances 
 * of course units with the required information and getter and setter methods to access and modify the 
 * attributes. It also includes methods to calculate the overall mark for the unit based on the assignment 
 * and final exam marks and determine the final grade for the unit. The "reportGrade()" method is overridden 
 * from the base class to display the grade report for the student, showing their name, student number, 
 * unit ID, overall mark, and final grade for the course work unit. This class is an essential component of 
 * the "Student Grade System" and facilitates the management and analysis of course work-related information 
 * for students.
 * 
 */

public class Unit_Course extends Unit {
	private String unitID;
	private int level, assignment1Mark, assignment2Mark, finalExamMark;
	private Student student; // Add a Student reference field
	
	// default constructor
	public Unit_Course() {
		super();
	}

	// constructor
	public Unit_Course(String unitID, int level, int assignment1Mark, int assignment2Mark, int finalExamMark) {
		super();
		this.unitID = unitID;
		this.level = level;
		this.assignment1Mark = assignment1Mark;
		this.assignment2Mark = assignment2Mark;
		this.finalExamMark = finalExamMark;
	}
	
	public Unit_Course(String enrolmentType) {
		super(enrolmentType);
	}

	// getter & setter
	public String getUnitID() {
		return unitID;
	}

	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAssignment1Mark() {
		return assignment1Mark;
	}

	public void setAssignment1Mark(int assignment1Mark) {
		this.assignment1Mark = assignment1Mark;
	}

	public int getAssignment2Mark() {
		return assignment2Mark;
	}

	public void setAssignment2Mark(int assignment2Mark) {
		this.assignment2Mark = assignment2Mark;
	}

	public int getFinalExamMark() {
		return finalExamMark;
	}

	public void setFinalExamMark(int finalExamMark) {
		this.finalExamMark = finalExamMark;
	}
	
	// overall mark
	public double overallMark() {
		return (assignment1Mark * 0.25) + (assignment2Mark * 0.25) + (finalExamMark * 0.5);
	}
	
	// final grade
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
	
	// Grade report (override from the base class)
    	@Override
    public void reportGrade() {
        System.out.println("C " +
                "Name: " + student.getFirstName() + " " + student.getLastName() +
                " Student number: " + student.getStudentNumber() +
                " Unit ID: " + unitID +
                " Overall mark: " + overallMark() +
                " Final grade: " + finalGrade());
    }
	
}
