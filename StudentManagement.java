import java.util.ArrayList;
import java.util.Scanner;

// A simple Java program to manage student records

class Student {
    int rollNumber;
    String name;
    String course;

    // Constructor to initialize student details
    Student(int rollNumber, String name, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.course = course;
    }

    // Method to display student details
    public void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("-----------------------");
    }
}

public class StudentManagement {
    // List to store student objects
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.println("Adding a new student...");
                    addStudent();
                    break;
                case 2:
                    System.out.println("Viewing all students...");
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Searching for a student...");
                    searchStudent();
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Thank you for using the Student Management System!");
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student s = new Student(roll, name, course);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : studentList) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        boolean found = false;
        for (Student s : studentList) {
            if (s.rollNumber == roll) {
                System.out.println("Student Found:");
                s.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll Number " + roll + " not found.");
        }
    }
}
// This code implements a simple Student Management System in Java.
// It allows adding, viewing, and searching for students by their roll number.
// The program uses an ArrayList to store student objects and a Scanner for user input.
// The main menu is displayed in a loop until the user chooses to exit.