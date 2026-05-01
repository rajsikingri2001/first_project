// ============================================================
//  FILE: StudentManagement.java
//  PURPOSE: Main program — runs the menu-driven console app
//  HOW TO RUN:
//    1. Open terminal / command prompt
//    2. Navigate to the folder containing these files
//    3. Compile:  javac Student.java StudentManagement.java
//    4. Run:      java StudentManagement
// ============================================================

import java.util.ArrayList;   // for ArrayList
import java.util.Scanner;      // for reading user input

public class StudentManagement {

    // ── Global ArrayList ─────────────────────────────────────
    // This is our "database" — it stores all Student objects
    // ArrayList can grow/shrink dynamically (unlike a fixed array)
    static ArrayList<Student> studentList = new ArrayList<>();

    // ── Scanner for reading keyboard input ───────────────────
    static Scanner scanner = new Scanner(System.in);

    // ─────────────────────────────────────────────────────────
    //  MAIN METHOD — entry point of the program
    // ─────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   🎓  Student Management System      ║");
        System.out.println("║        Core Java — Console App       ║");
        System.out.println("╚══════════════════════════════════════╝");

        int choice = 0; // stores the user's menu selection

        // Keep showing the menu until the user chooses to exit (option 4)
        while (choice != 4) {

            // ── Display Menu ──────────────────────────────────
            System.out.println("\n-------- MENU --------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // ── Read Choice ───────────────────────────────────
            // We wrap it in try-catch to handle non-numeric input gracefully
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Please enter a valid number (1-4).");
                continue; // go back to the top of the loop
            }

            // ── Switch on User Choice ─────────────────────────
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("\n👋 Goodbye! Exiting the program.");
                    break;
                default:
                    System.out.println("⚠ Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }

        scanner.close(); // always close the Scanner when done
    }

    // ─────────────────────────────────────────────────────────
    //  FUNCTION 1: addStudent()
    //  PURPOSE : Read student details from user and add to list
    // ─────────────────────────────────────────────────────────
    static void addStudent() {

        System.out.println("\n--- Add New Student ---");

        // ── Read Name ─────────────────────────────────────────
        System.out.print("Enter student name  : ");
        String name = scanner.nextLine().trim();

        // Validate: name should not be empty
        if (name.isEmpty()) {
            System.out.println("⚠ Name cannot be empty.");
            return; // exit this function and go back to menu
        }

        // ── Read Age ──────────────────────────────────────────
        int age = 0;
        System.out.print("Enter student age   : ");
        try {
            age = Integer.parseInt(scanner.nextLine().trim());

            // Age should be realistic for a college student
            if (age < 16 || age > 35) {
                System.out.println("⚠ Age must be between 16 and 35.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ Invalid age. Please enter a number.");
            return;
        }

        // ── Read Course ───────────────────────────────────────
        System.out.print("Enter course name   : ");
        String course = scanner.nextLine().trim();

        if (course.isEmpty()) {
            System.out.println("⚠ Course cannot be empty.");
            return;
        }

        // ── Create Student object and add to ArrayList ────────
        // 'new Student(...)' calls the constructor in Student.java
        Student newStudent = new Student(name, age, course);
        studentList.add(newStudent); // like JavaScript's array.push()

        System.out.println("✅ Student added successfully!");
    }

    // ─────────────────────────────────────────────────────────
    //  FUNCTION 2: viewAllStudents()
    //  PURPOSE : Display all students in the ArrayList
    // ─────────────────────────────────────────────────────────
    static void viewAllStudents() {

        System.out.println("\n--- Student List ---");

        // If no students have been added yet
        if (studentList.isEmpty()) {
            System.out.println("📭 No students found. Please add some first.");
            return;
        }

        // Loop through the ArrayList using a for loop
        // 'i' is the index (position) — starts at 0
        for (int i = 0; i < studentList.size(); i++) {
            // studentList.get(i) fetches the student at position i
            System.out.println((i + 1) + ". " + studentList.get(i));
        }

        System.out.println("Total students: " + studentList.size());
    }

    // ─────────────────────────────────────────────────────────
    //  FUNCTION 3: deleteStudent()
    //  PURPOSE : Remove a student from the ArrayList by number
    // ─────────────────────────────────────────────────────────
    static void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        // Can't delete if list is empty
        if (studentList.isEmpty()) {
            System.out.println("📭 No students to delete.");
            return;
        }

        // Show the list so the user knows which number to enter
        viewAllStudents();

        System.out.print("\nEnter the student number to delete: ");
        int number;

        try {
            number = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Please enter a valid number.");
            return;
        }

        // Validate the number is within range
        // List is 0-indexed internally, but we show 1-indexed to the user
        if (number < 1 || number > studentList.size()) {
            System.out.println("⚠ Invalid number. Please choose from the list.");
            return;
        }

        // Remove the student (convert from 1-indexed to 0-indexed)
        Student removed = studentList.remove(number - 1); // ArrayList.remove()
        System.out.println("🗑 Removed: " + removed);
    }
}
