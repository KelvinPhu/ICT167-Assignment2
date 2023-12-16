package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Student Grade System
 * Author: HUYNH THIEN PHU
 * Date: 28TH JULY 2023
 * File Name: Client.java
 * 
 * Purpose: The "client" class serves as the main program for the Student Grade System. It offers a 
 * user-friendly menu-driven interface to manage student information and grades. Users can load student 
 * details from a CSV file, remove students by their student number, view all student details (including 
 * specific course work or research information), analyze course work students' grades, report grade 
 * information for a specific student, sort students by their student numbers, and save the sorted student 
 * list to a new CSV file. The class efficiently handles the interactions with the system and provides 
 * essential functionalities to ensure effective management of student data and performance analysis.
 * 
 * Assumptions/Conditions: The Student Grade System is a Java-based program designed to manage and analyze 
 * student information. It loads student data from a CSV file, assuming that the file is well-formatted and 
 * contains valid information for both course work and research students. The system performs various 
 * operations, including displaying all student details, removing a student by their unique student number, 
 * analyzing course work students' grades, and reporting the grade information of a specific student by their 
 * student number. Additionally, the system allows users to sort the student list based on student numbers 
 * and output the sorted data to another CSV file. It is important to note that the system assumes the data's 
 * validity and uniqueness of student numbers for accurate functioning. However, it lacks data persistence 
 * beyond the program's runtime and is designed for single-user interaction.
 * 
 */


public class client {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Display student information
        studentInformation();
        
        System.out.println("=======================================");
        System.out.println("Student Grade System program starting");
        System.out.println("=======================================");

        // Load students' information from the default file
        loadStudentsInformationFromFile(students, "C:\\Users\\HP\\eclipse\\java-2020-09\\eclipse\\ICT167_assignment_2\\src\\assignment2\\file\\students.txt");

        int choice = 0;

        do {
            // Display the menu options
            menuDisplay();

            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                	// end the program
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                case 2:
                	// Load students' information from a CSV file
                    System.out.println("Please enter your file name (file source): ");
                    String fileName = sc.nextLine();
                    loadStudentsInformationFromFile(students, fileName);
                    break;

                case 3:
                	// Remove a student by student number
                    System.out.println("Please enter a student number to remove: ");
                    long studentNumber = sc.nextLong();
                    removeStudentByStudentNumber(studentNumber);
                    break;

                case 4:
                    // Display all student details
                    displayAllStudentDetails(students);
                    break;

                case 5:
                	// Analyze course work students' grades
                	analyzeCourseWorkStudentGrades(students);
                    break;

                case 6:
                	// Report grade of a student by student number
                	System.out.println("Please enter the student number: ");
                	studentNumber = sc.nextLong();
                	sc.nextLine();
                	reportGradeOfStudent(students, studentNumber);
                    break;
                case 7:
                	// Sort students by student number
                	sortStudentsByStudentNumber(students);
                	displayAllStudentDetails(students);
                	System.out.println("Students sorted by student number: ");
                    break;

                case 8:
                	// Output sorted students to a CSV file
                	 System.out.println("Please enter the file name to save the sorted students (CSV format): ");
                     fileName = sc.nextLine();
                     outputSortedStudentsToCSV(students, fileName);
                    break;

                default:
                	System.out.println("Invalid choice option");
                    break;
            }

        } while (choice != 1);

        sc.close();
    }
    
    /**
     * Displays student information.
     */
    public static void studentInformation() {
        System.out.println("Title: ICT167 Assignment 2");
        System.out.println("Author / Student Name: Huynh Thien Phu");
        System.out.println("Student ID: 34237012");
        System.out.println("Unit Code: ICT167");
        System.out.println("Unit Name: Principles of Computer Science");
        System.out.println("Professor: Kelvin Wong");
        System.out.println("File Name: client.java");
        System.out.println("Date: 28th JuLY 2023");
    }

    /**
     * Menu display information.
     */
    public static void menuDisplay() {
        System.out.println("\nMenu Options:\r\n"
                + "1. Quit: Exit the program.\r\n"
                + "2. Add marks information from a CSV file: Load student information from a CSV file.\r\n"
                + "3. Remove a student by student number: Remove a student and their information from the list.\r\n"
                + "4. Display all student details: Show all details of the students in the list.\r\n"
                + "5. Analyze course work students' grades: Determine how many course work students obtained an overall mark equal to or above the average overall mark and how many obtained an overall mark below the average overall mark.\r\n"
                + "6. Report grade of a student by student number: Display the grade information of a student given their student number.\r\n"
                + "7. Sort students by student number: Sort the list of students in ascending order of their student numbers.\r\n"
                + "8. Output sorted students to a CSV file: Save the sorted list of students to a CSV file.\r\n"
                + "");
    }
    
//  --------------------------------------------------------------------------------------------------------------------------------------------------
//  8 Options display menu logic function

    
    /**
     * Option 2 load students information from a CSV file
     */
    public static void loadStudentsInformationFromFile(ArrayList<Student> students , String fileName) {
        try {
            // Read student information from the CSV file
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");

                if (data.length >= 9) {
                    // Extract the common student information
                    String enrolmentType = data[0].trim().toUpperCase(); // Convert to uppercase
                    String firstName = data[1].trim();
                    String lastName = data[2].trim();
                    long studentNumber;

                    // Check if the student number is a valid long value
                    try {
                        studentNumber = Long.parseLong(data[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid student number format: " + data[3]);
                        continue;
                    }

                    // Process course work students
                    if (enrolmentType.equalsIgnoreCase("C")) {
                        if (data.length >= 9) {
                            String unitId = data[4].trim();
                            int level = Integer.parseInt(data[5].trim());

                            // Check if the assignment and exam marks are valid integer values
                            int assignment1Mark, assignment2Mark, finalExamMark;
                            try {
                                assignment1Mark = Integer.parseInt(data[6].trim());
                                assignment2Mark = Integer.parseInt(data[7].trim());
                                finalExamMark = Integer.parseInt(data[8].trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid marks format for course work student: " + line);
                                continue;
                            }

                            // Create the Unit_Course and Student_Course instances
                            Unit_Course unitCourse = new Unit_Course();
                            unitCourse.setUnitID(unitId);
                            unitCourse.setLevel(level);
                            unitCourse.setAssignment1Mark(assignment1Mark);
                            unitCourse.setAssignment2Mark(assignment2Mark);
                            unitCourse.setFinalExamMark(finalExamMark);

                            Student_Course studentCourse = new Student_Course();
                            studentCourse.setEnrolmentType(enrolmentType);
                            studentCourse.setFirstName(firstName);
                            studentCourse.setLastName(lastName);
                            studentCourse.setStudentNumber(studentNumber);
                            studentCourse.setUnitCourse(unitCourse);

                            // Use the existing instance of Student_Course
                            students.add(studentCourse);
                        }
                    }
                    // Process research students
                    else if (enrolmentType.equalsIgnoreCase("R")) {
                        if (data.length >= 9) {
                            // Check if the proposal and dissertation marks are valid integer values
                            int proposalMark, dissertationMark;
                            try {
                                proposalMark = Integer.parseInt(data[4].trim());
                                dissertationMark = Integer.parseInt(data[5].trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid marks format for research student: " + line);
                                continue;
                            }

                            // Create the Research and Student_Research instances
                            Research research = new Research();
                            research.setProposalMark(proposalMark);
                            research.setFinalDissertationMark(dissertationMark);

                            Student_Research studentResearch = new Student_Research();
                            studentResearch.setEnrolmentType(enrolmentType);
                            studentResearch.setFirstName(firstName);
                            studentResearch.setLastName(lastName);
                            studentResearch.setStudentNumber(studentNumber);
                            studentResearch.setResearch(research);

                            // Use the existing instance of Student_Research
                            students.add(studentResearch);
                        }
                    }
                }
            }

            sc.close();
            System.out.println("loaded successfully student information from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found: " + fileName);
        } catch (Exception e) {
            System.out.println("Got error while loading the file.");
            e.printStackTrace();
        }
    }
    
    
    /**
     * option 3: Remove a student by student number
     * 
     * @param studentNumber The student number of the student to be removed.
     */
    public static void removeStudentByStudentNumber(long studentNumber) {
        // Initialize a reference to the student to be removed
        Student removeStudent = null;

        // Search for the student in the list by their student number
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                // If found, assign the student to the removeStudent variable and break the loop
                removeStudent = student;
                break;
            }
        }

        // Check if the student was found
        if (removeStudent != null) {
            // If the student is found, display the student's information and ask for confirmation
            System.out.println("Please confirm if you want to remove this student: ");
            System.out.println("Student number: " + removeStudent.getStudentNumber());
            System.out.println("Student name: " + removeStudent.getFirstName() + " " + removeStudent.getLastName());
            System.out.println("Student type: " + (removeStudent instanceof Student_Course ? "Course Work" : "Research"));
            System.out.println("If you are confirm, please press 'Y', or press any key to cancel");

            // Read user input for confirmation
            Scanner sc = new Scanner(System.in);
            String confirm = sc.nextLine();

            // Check if the user confirms the removal
            if (confirm.equalsIgnoreCase("Y")) {
                // If confirmed, remove the student from the list
                students.remove(removeStudent);
                System.out.println("Student successfully removed.");
            } else {
                // If canceled, display a message indicating that the removal was canceled
                System.out.println("Removal canceled. Student is not removed.");
            }
        } else {
            // If the student is not found, display a message indicating that the student was not found
            System.out.println("Student with student number " + studentNumber + " was not found!");
        }
    }
    
    
    /**
     * Option 4: Display all student details
     * 
     * @param students The ArrayList of students containing both course work and research students.
     */
    public static void displayAllStudentDetails(ArrayList<Student> students) {
        System.out.println("Student detail list: ");
        for (Student student : students) {
            // Display common student details: type, name, and student number
            System.out.println("Student type: " + student.getClass().getSimpleName());
            System.out.println("Student name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Student number: " + student.getStudentNumber());

            // Check if the student is of type Student_Course (course work student)
            if (student instanceof Student_Course) {
                // If the student is of type Student_Course, cast the student to Student_Course type
                Student_Course courseStudent = (Student_Course) student;

                // Display enrolment type
                System.out.println("Enrolment Type: " + courseStudent.getEnrolmentType());

                // Check if the associated Unit_Course exists
                Unit_Course unitCourse = courseStudent.getUnitCourse();
                if (unitCourse != null) {
                    // If the associated Unit_Course exists, display its details: unit ID, overall mark, and final grade
                    System.out.println("Unit ID: " + unitCourse.getUnitID());
                    System.out.println("Overall Mark: " + unitCourse.overallMark());
                    System.out.println("Final Grade: " + unitCourse.finalGrade());
                } else {
                    // If no associated Unit_Course, display a message indicating it
                    System.out.println("No Unit Course Information");
                }
            }
            // Check if the student is of type Student_Research (research student)
            else if (student instanceof Student_Research) {
                // If the student is of type Student_Research, cast the student to Student_Research type
                Student_Research researchStudent = (Student_Research) student;

                // Display enrolment type
                System.out.println("Enrolment Type: " + researchStudent.getEnrolmentType());

                // Check if the associated Research exists
                Research research = researchStudent.getResearch();
                if (research != null) {
                    // If the associated Research exists, display its details: proposal mark and final dissertation mark
                    System.out.println("Research Marks:");
                    System.out.println("Proposal Mark: " + research.getProposalMark());
                    System.out.println("Final Dissertation Mark: " + research.getFinalDissertationMark());
                    // You can add more research-related details here if needed
                } else {
                    // If no associated Research, display a message indicating it
                    System.out.println("No Research Information");
                }
            }

            System.out.println(); // Add an empty line between each student's details
        }
    }
    
    
    /**
     * Option 5: Analyze course work students' grades
     * 
     * @param students The ArrayList of students containing both course work and research students.
     */
    public static void analyzeCourseWorkStudentGrades(ArrayList<Student> students) {
        int totalMarks = 0;
        int numCourseWorkStudents = 0;

        // Calculate the total marks and count the number of course work students
        for (Student student : students) {
            // Check if the student is of type Student_Course (course work student)
            if (student instanceof Student_Course) {
                // If the student is of type Student_Course, cast the student to Student_Course type
                Student_Course courseStudent = (Student_Course) student;

                // Check if the associated Unit_Course exists
                Unit_Course unitCourse = courseStudent.getUnitCourse();
                if (unitCourse != null) {
                    // If the associated Unit_Course exists, add the overall mark to the total and increment the count
                    totalMarks += unitCourse.overallMark();
                    numCourseWorkStudents++;
                }
            }
        }

        // Calculate the average overall mark for course work students
        double averageOverallMark = (double) totalMarks / numCourseWorkStudents;

        // Count the number of course work students above and below the average overall mark
        int numAboveAverage = 0;
        int numBelowAverage = 0;
        for (Student student : students) {
            // Check if the student is of type Student_Course (course work student)
            if (student instanceof Student_Course) {
                // If the student is of type Student_Course, cast the student to Student_Course type
                Student_Course courseStudent = (Student_Course) student;

                // Check if the associated Unit_Course exists
                Unit_Course unitCourse = courseStudent.getUnitCourse();
                if (unitCourse != null) {
                    // If the associated Unit_Course exists, get the overall mark
                    double overallMark = unitCourse.overallMark();

                    // Compare the overall mark with the average and increment the respective counters
                    if (overallMark >= averageOverallMark) {
                        numAboveAverage++;
                    } else {
                        numBelowAverage++;
                    }
                }
            }
        }

        // Display the results
        System.out.println("Course work student grades analysis:");
        System.out.println("Average overall mark: " + averageOverallMark);
        System.out.println("Number of course work students above average: " + numAboveAverage);
        System.out.println("Number of course work students below average: " + numBelowAverage);
    }
    
    
    /**
     * Option 6: Report grade of a student by student number
     * 
     * @param students      The ArrayList of students containing both course work and research students.
     * @param studentNumber The student number for which the grade information is to be reported.
     */
    public static void reportGradeOfStudent(ArrayList<Student> students, long studentNumber) {
        boolean found = false;

        // Search for the student with the given student number
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                found = true;

                // Check if the student is of type Student_Course (course work student)
                if (student instanceof Student_Course) {
                    // If the student is of type Student_Course, cast the student to Student_Course type
                    Student_Course courseStudent = (Student_Course) student;

                    // Check if the associated Unit_Course exists
                    Unit_Course unitCourse = courseStudent.getUnitCourse();
                    if (unitCourse != null) {
                        // If the associated Unit_Course exists, print the grade information
                        System.out.println("Grade information for student with student number " + studentNumber);
                        System.out.println("Overall Mark: " + unitCourse.overallMark());
                        System.out.println("Final Grade: " + unitCourse.finalGrade());
                    } else {
                        // If the associated Unit_Course does not exist, the student is not a course work student
                        System.out.println("Student with student number " + studentNumber + " is not a course work student.");
                    }
                } else if (student instanceof Student_Research) {
                    // If the student is of type Student_Research (research student), print the indication
                    System.out.println("Student with student number " + studentNumber + " is a research student.");
                }

                // Exit the loop since the student has been found
                break;
            }
        }

        // If no student with the given student number is found, print a message indicating so
        if (!found) {
            System.out.println("Student with student number " + studentNumber + " was not found.");
        }
    }
    
    
    /**
     * Option 7: Sort students by student number
     * 
     * @param students The ArrayList of students to be sorted.
     */
    public static void sortStudentsByStudentNumber(ArrayList<Student> students) {
        int n = students.size();

        // Apply the insertion sort algorithm to sort the students based on their student numbers
        for (int i = 1; i < n; ++i) {
            Student key = students.get(i);
            int j = i - 1;

            // Move elements of students[0..i-1] that are greater than key.studentNumber
            // to positions ahead of their current position
            while (j >= 0 && students.get(j).getStudentNumber() > key.getStudentNumber()) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }

            // Place the key (current student) at the correct position in the sorted list
            students.set(j + 1, key);
        }
    }
    
    
    /**
     * Option 8: Output sorted students to a CSV file
     * 
     * @param students The ArrayList of students to be written to the CSV file.
     * @param fileName The name of the CSV file to which the student data will be written.
     */
    public static void outputSortedStudentsToCSV(ArrayList<Student> students, String fileName) {
        try {
            StringBuilder csvData = new StringBuilder();
            csvData.append("EnrolmentType,FirstName,LastName,StudentNumber,UnitID,Level,Assignment1Mark,Assignment2Mark,FinalExamMark,ProposalMark,DissertationMark\n");

            // Write the sorted student data to the CSV string
            for (Student student : students) {
                String enrolmentType = student instanceof Student_Course ? "C" : "R";
                String firstName = student.getFirstName();
                String lastName = student.getLastName();
                long studentNumber = student.getStudentNumber();

                if (student instanceof Student_Course) {
                    Student_Course courseStudent = (Student_Course) student;
                    Unit_Course unitCourse = courseStudent.getUnitCourse();
                    String unitID = unitCourse.getUnitID();
                    int level = unitCourse.getLevel();
                    int assignment1Mark = unitCourse.getAssignment1Mark();
                    int assignment2Mark = unitCourse.getAssignment2Mark();
                    int finalExamMark = unitCourse.getFinalExamMark();

                    // Append the course student information to the CSV data
                    csvData.append(String.format("%s,%s,%s,%d,%s,%d,%d,%d,%d,,\n",
                            enrolmentType, firstName, lastName, studentNumber,
                            unitID, level, assignment1Mark, assignment2Mark, finalExamMark));
                } else if (student instanceof Student_Research) {
                    Student_Research researchStudent = (Student_Research) student;
                    Research research = new Research();
                    int proposalMark = research.getProposalMark();
                    int dissertationMark = research.getFinalDissertationMark();

                    // Append the research student information to the CSV data
                    csvData.append(String.format("%s,%s,%s,%d,,,,,%d,%d\n",
                            enrolmentType, firstName, lastName, studentNumber,
                            proposalMark, dissertationMark));
                }
            }

            // Write the CSV string to a file using java.nio.file.Files
            java.nio.file.Files.write(java.nio.file.Paths.get(fileName), csvData.toString().getBytes());
            System.out.println("Sorted students successfully output to CSV file: " + fileName);
        } catch (java.io.IOException e) {
            System.out.println("Error writing to CSV file: " + fileName);
        }
    }

}
