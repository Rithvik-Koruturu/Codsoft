import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

class StudentManagementApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagementSystem system = new StudentManagementSystem();

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    saveDataToFile();
                    break;
                case 6:
                    readDataFromFile();
                    break;
                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);
    }

    private static void displayMenu() {
        System.out.println("\n----- Student Management System -----");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student");
        System.out.println("3. Search for a student");
        System.out.println("4. Display all students");
        System.out.println("5. Save data to file");
        System.out.println("6. Read data from file");
        System.out.println("7. Exit");
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        system.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent() {
        System.out.print("Enter the roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully!");
    }

    private static void searchStudent() {
        System.out.print("Enter the roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = system.searchStudent(rollNumber);

        if (student != null) {
            System.out.println("Student found:\n" + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        ArrayList<Student> students = system.getStudents();

        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("----- All Students -----");
            system.displayAllStudents();
        }
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(system.getStudents());
            System.out.println("Data saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    private static void readDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            ArrayList<Student> students = (ArrayList<Student>) ois.readObject();
            system.getStudents().clear();
            system.getStudents().addAll(students);
            System.out.println("Data read from file successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading data from file: " + e.getMessage());
        }
    }
}
