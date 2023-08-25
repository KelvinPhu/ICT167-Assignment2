package assignment2;

/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Student_Course.java
 * 
 * Purpose: The "Student_Course" class is a subclass of "Student" specifically designed to represent 
 * course-based students with an enrolment type denoted as "C." It holds information such as the student's 
 * first name, last name, and student number. Additionally, it includes a reference to the "Unit_Course" 
 * class to manage course-related details. The class provides methods to access and modify the enrolment 
 * type and associated unit course. By overriding the "reportGrade()" method, it displays the student's grade 
 * information with the enrolment type indicated as "C." This class plays a vital role in the broader 
 * "Student Grade System" by facilitating the management and presentation of course-based student information.
 * 
 */

public class Student_Course extends Student {
	private String enrolmentType;
	private Unit_Course unitCourse;

	// constructor
	public Student_Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student_Course(String enrolmentType, String firstName, String lastName, long studentNumber) {
		super(firstName, lastName, studentNumber);
		this.enrolmentType = enrolmentType;
	}

	
	// getter & setter
	public String getEnrolmentType() {
		return enrolmentType;
	}

	public void setEnrolmentType(String enrolmentType) {
		this.enrolmentType = enrolmentType;
	}
	
	public Unit_Course getUnitCourse() {
		return unitCourse;
	}

	public void setUnitCourse(Unit_Course unitCourse) {
		this.unitCourse = unitCourse;
	}

	// Grade report (override from the base class)
    @Override
    public void reportGrade() {
        System.out.println("C " +
                " Name: " + getFirstName() + " " + getLastName() +
                " Student number: " + getStudentNumber() +
                " Enrolment Type: " + enrolmentType);
    }
}
