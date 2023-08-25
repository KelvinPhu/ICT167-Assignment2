package assignment2;

/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Student_Research.java
 * 
 * Purpose: The "Student_Research" class is a subclass of "Student" intended to represent research-based 
 * students with an enrolment type denoted as "R." It inherits attributes such as the student's first name, 
 * last name, and student number from the base class. The class also contains a reference to the "Research" 
 * class to manage research-related details. It provides methods to access and modify the enrolment type and 
 * associated research information. By overriding the "reportGrade()" method, it displays the student's grade 
 * information for research students, including the overall mark and the final grade. This class is an 
 * essential component of the broader "Student Grade System," playing a key role in managing and presenting 
 * data for research-based students.
 * 
 */

public class Student_Research extends Student {
	private String enrolmentType;
	private Research research;

	// constructor
	public Student_Research() {
		super();
	}

	public Student_Research(String enrolmentType) {
		super();
		this.enrolmentType = enrolmentType;
	}

	public Student_Research(String firstName, String lastName, long studentNumber) {
		super(firstName, lastName, studentNumber);
		// TODO Auto-generated constructor stub
	}

	//getter & setter
	public String getEnrolmentType() {
		return enrolmentType;
	}

	public void setEnrolmentType(String enrolmentType) {
		this.enrolmentType = enrolmentType;
	}
	
	
	public Research getResearch() {
		return research;
	}

	public void setResearch(Research research) {
		this.research = research;
	}

	// report grade
	public void reportGrade() {
		System.out.println("R"
				+ "Student name: " +getFirstName()+ " " +getLastName()
				+ "Student number: " +getStudentNumber()
				+ "The Overall mark: " +research.overallMark()
				+ "The final grade: " +research.finalGrade());
	}
}
