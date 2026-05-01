// ============================================================
//  FILE: Student.java
//  PURPOSE: Blueprint (class) for a Student object
//  CONCEPT: This is like a template — every student we create
//           will have these three fields.
// ============================================================

public class Student {

    // ── Attributes (fields) ──────────────────────────────────
    // These store the data for one student
    String name;    // student's full name
    int    age;     // student's age
    String course;  // course the student is enrolled in

    // ── Constructor ──────────────────────────────────────────
    // A constructor runs automatically when we create a new Student
    // It initialises the fields with the values we pass in
    public Student(String name, int age, String course) {
        this.name   = name;    // 'this' refers to the current object
        this.age    = age;
        this.course = course;
    }

    // ── toString() ───────────────────────────────────────────
    // This method returns a nicely formatted string for printing
    // It is called automatically when we use System.out.println(student)
    @Override
    public String toString() {
        return "Name: " + name + " | Age: " + age + " | Course: " + course;
    }
}
