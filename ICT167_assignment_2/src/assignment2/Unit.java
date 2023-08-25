package assignment2;

/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Unit_Course.java
 * 
 * Purpose: The "Unit" class is a base class that represents a unit in the student grade system. It has a 
 * single attribute "enrolmentType" to indicate the type of enrolment for the unit. The class provides 
 * constructors to create instances of units with the specified enrolment type and getter and setter methods 
 * to access and modify the enrolment type attribute. Additionally, it includes a "reportGrade()" method to 
 * display the grade report for the unit, which is set to "NA" (Not Applicable) by default. This class serves 
 * as a foundation for more specific unit types like "Unit_Course" and "Research," allowing for better 
 * organization and handling of units within the "Student Grade System."
 * 
 */

public class Unit {
	private String enrolmentType;

	// constructor
	public Unit() {
		super();
	}

	public Unit(String enrolmentType) {
		super();
		this.enrolmentType = enrolmentType;
	}

	// getter & setter
	public String getEnrolmentType() {
		return enrolmentType;
	}

	public void setEnrolmentType(String enrolmentType) {
		this.enrolmentType = enrolmentType;
	}
	
	// Grade report
    public void reportGrade() {
        System.out.println("NA");
    }
}
