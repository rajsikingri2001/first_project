# 🎓 Student Management System
**College Project | HTML + CSS + JavaScript + Core Java**

---

## 📁 File Structure

```
StudentManagementSystem/
│
├── index.html              ← Frontend (HTML + CSS + JavaScript)
│
├── Student.java            ← Java class: blueprint for a Student object
│
├── StudentManagement.java  ← Java main program: menu-driven console app
│
└── README.md               ← This file
```

---

## ⚙️ How the Project Works

### Frontend (index.html)
The browser-based part uses **HTML** for structure, **CSS** for styling, and
**JavaScript** for logic — all in one file.

| Part | Role |
|---|---|
| HTML form | Collects student Name, Age, Course |
| JavaScript array (`studentList[]`) | Stores student objects in memory |
| `addStudent()` function | Reads form → validates → pushes to array → redraws table |
| `deleteStudent(id)` function | Filters out the chosen student → redraws table |
| `renderTable()` function | Loops through array and builds the HTML table dynamically |

**Data lives only in memory** — it resets when you refresh the page.

---

### Backend (Java Console App)
The Java part runs entirely in the **terminal**. It has no connection to the frontend.

| File | Role |
|---|---|
| `Student.java` | Defines a `Student` class with fields: `name`, `age`, `course` |
| `StudentManagement.java` | Main program with a menu: Add / View / Delete / Exit |

The `ArrayList<Student>` acts as the in-memory list (same concept as the JS array).

---

## 🚀 How to Run

### Frontend
1. Open `index.html` in any browser (double-click the file).
2. Fill in the form and click **Add Student**.
3. Click **Delete** on any row to remove a student.

### Java Backend
```bash
# Step 1 — Open terminal and go to the project folder
cd path/to/StudentManagementSystem

# Step 2 — Compile both Java files
javac Student.java StudentManagement.java

# Step 3 — Run the program
java StudentManagement
```

**Sample Console Session:**
```
╔══════════════════════════════════════╗
║   🎓  Student Management System      ║
║        Core Java — Console App       ║
╚══════════════════════════════════════╝

-------- MENU --------
1. Add Student
2. View All Students
3. Delete Student
4. Exit
Enter your choice: 1

--- Add New Student ---
Enter student name  : Riya Sharma
Enter student age   : 20
Enter course name   : Computer Science
✅ Student added successfully!
```

---

## 📖 Step-by-Step Explanation (for viva)

### How to explain the frontend:
> "I built a web page using HTML, CSS, and JavaScript.
> The HTML has a form with three inputs — Name, Age, and Course.
> When the user clicks 'Add Student', a JavaScript function called `addStudent()`
> reads those inputs, validates them, creates a student object, and pushes it into
> an array called `studentList`. Then `renderTable()` loops through the array and
> dynamically builds the HTML table using `innerHTML`. When the user clicks Delete,
> the `deleteStudent()` function uses `filter()` to remove that student from the
> array and redraws the table."

### How to explain the Java backend:
> "I created two Java files. `Student.java` defines a class with three fields —
> name, age, and course — and a constructor to set them. `StudentManagement.java`
> is the main program. It uses a `while` loop to keep showing a menu. Based on the
> user's choice, it calls one of three methods: `addStudent()` which creates a new
> Student object and adds it to an ArrayList, `viewAllStudents()` which loops through
> the ArrayList and prints each student, and `deleteStudent()` which removes a student
> by index using `ArrayList.remove()`. I used `Scanner` to read keyboard input and
> `try-catch` to handle invalid input gracefully."

---

## ❓ Viva Questions & Answers

### General

**Q1. What is this project about?**
> This is a Student Management System where you can add, view, and delete student
> records. The frontend is built with HTML, CSS, and JavaScript, and the backend
> is a separate Core Java console application.

**Q2. Why are the frontend and backend not connected?**
> Connecting Java to a browser requires a web server (like Spring Boot or Servlets),
> which is an advanced topic. For this beginner project, we keep them separate to
> focus on the core concepts of each technology.

**Q3. What is the difference between a Java class and a JavaScript object?**
> A Java class (`Student.java`) is a formal blueprint defined before runtime using
> fixed data types. A JavaScript object is more flexible — you can create it with
> curly braces `{}` and add properties dynamically without declaring types.

---

### JavaScript / Frontend

**Q4. What is an array in JavaScript? How did you use it?**
> An array is a list that can hold multiple values. I used `studentList = []` to
> store all student objects. `push()` adds a student, and `filter()` removes one.

**Q5. What is DOM manipulation?**
> DOM stands for Document Object Model. It's the browser's representation of the
> HTML page as objects. Using JavaScript, I access elements like
> `document.getElementById("name")` and change their content with `innerHTML` to
> update the page without reloading.

**Q6. What does the `filter()` function do?**
> `filter()` creates a new array containing only the elements that pass a test.
> I use it to remove a student by keeping all students whose ID does not match
> the one being deleted.

**Q7. What is validation? Where did you use it?**
> Validation means checking that user input is correct before processing it.
> I check that the name is not empty, the age is a number between 16–35, and a
> course is selected. If not, an error message is shown and the student is not added.

**Q8. What is an event in JavaScript?**
> An event is something that happens in the browser, like a button click or a
> key press. I used `onclick="addStudent()"` on the button and `addEventListener`
> for the Enter key so the form submits in both ways.

---

### Java / Backend

**Q9. What is a class in Java?**
> A class is a blueprint or template for creating objects. My `Student` class
> defines what data every student object will have: `name`, `age`, and `course`.

**Q10. What is a constructor?**
> A constructor is a special method that runs automatically when an object is
> created with `new`. It initialises the object's fields with the values passed in.
> Example: `new Student("Riya", 20, "CS")` sets name="Riya", age=20, course="CS".

**Q11. What is ArrayList? Why did you use it instead of a normal array?**
> `ArrayList` is a resizable list from `java.util`. A normal array has a fixed
> size declared at creation. Since we don't know how many students will be added,
> `ArrayList` is better because it grows and shrinks automatically.

**Q12. What is the Scanner class?**
> `Scanner` is a Java class used to read input from the keyboard (or other sources).
> I created `Scanner scanner = new Scanner(System.in)` and used `scanner.nextLine()`
> to read each line the user types.

**Q13. What is a while loop? Why did you use it?**
> A `while` loop repeats a block of code as long as a condition is true. I used
> `while (choice != 4)` so the menu keeps showing until the user selects Exit (4).

**Q14. What is try-catch?**
> `try-catch` is used to handle exceptions (errors) gracefully. I wrapped
> `Integer.parseInt()` in try-catch so that if the user types a letter instead of
> a number, the program shows a warning instead of crashing.

**Q15. What does `toString()` do?**
> `toString()` is a method that returns a String representation of an object.
> I overrode it in `Student.java` so that when I print a Student object, it shows
> the name, age, and course in a readable format automatically.

**Q16. What is `static` in Java?**
> `static` means a method or variable belongs to the class itself, not to any
> individual object. I marked `studentList`, `scanner`, and the methods as `static`
> so they can be called directly from `main()` without creating an object of
> `StudentManagement`.

**Q17. How does `ArrayList.remove()` work?**
> `ArrayList.remove(index)` removes the element at the given index and shifts
> all later elements one position to the left. Since my menu shows 1-based numbering,
> I subtract 1 before calling remove: `studentList.remove(number - 1)`.

**Q18. What is the difference between `==` and `.equals()` in Java?**
> `==` compares memory addresses (references), while `.equals()` compares the actual
> content of strings. For string comparison in Java, always use `.equals()`.
> (Not directly used here, but an important concept to know.)

---

## 📌 Key Concepts Summary

| Concept | JavaScript (Frontend) | Java (Backend) |
|---|---|---|
| Store multiple items | `Array` (`studentList[]`) | `ArrayList<Student>` |
| Add item | `push()` | `add()` |
| Remove item | `filter()` | `remove()` |
| Loop through | `for` loop | `for` loop |
| User input | HTML form + `getElementById` | `Scanner` + `nextLine()` |
| Blueprint/template | Object literal `{}` | `class Student` |
| Error handling | `if` validation | `try-catch` |

---

*Project by — [Your Name] | [Roll Number] | [College Name]*
