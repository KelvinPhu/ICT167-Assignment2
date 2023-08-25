package assignment2;

/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Student.java
 * 
 * Purpose: The "Student" class represents a basic student entity with attributes such as the student's first 
 * name, last name, and student number. It provides constructors to create student objects with the necessary 
 * information and getter and setter methods to access and modify these attributes. Additionally, the class 
 * includes a "reportGrade()" method, which by default prints a message indicating that there are no grades 
 * available for the student. The "equals" method is overridden to compare two student objects based on their 
 * student numbers. This class serves as the foundation for the "Student Grade System" and is used as a base 
 * class for more specialized student subclasses, such as "Student_Course" and "Student_Research." It 
 * encapsulates the common attributes and behavior shared among all types of students in the system.
 * 
 */

public class Student {
	private String firstName, lastName;
	private long studentNumber;
	
	// default constructor
	public Student() {
		
	}

	// constructor
	public Student(String firstName, String lastName, long studentNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentNumber = studentNumber;
	}

	//getter & setter
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(long studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	
	// grade report
	public void reportGrade() {
		System.out.println("There are no grade here!");
	}
	
	// Equals method to compare two student objects based on student number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student otherStudent = (Student) obj;
        return this.studentNumber == otherStudent.studentNumber;
    }
}
