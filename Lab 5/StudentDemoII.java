import java.util.GregorianCalendar;
import java.util.Scanner;

class Student {
    private static int studentCount = 0; // To keep track of the number of students
    private int registrationNumber;
    private String fullName;
    private GregorianCalendar dateOfJoining;
    private short semester;
    private float gpa;
    private float cgpa;

    // Parameterized constructor
    Student(String fullName, GregorianCalendar dateOfJoining, short semester, float gpa, float cgpa) {
        this.fullName = fullName;
        this.dateOfJoining = dateOfJoining;
        this.semester = semester;
        this.gpa = gpa;
        this.cgpa = cgpa;
        this.registrationNumber = generateRegistrationNumber();
        studentCount++; // Increment the student count after creating a new student
    }

    // Calculate registration number based on year and student count
    private int generateRegistrationNumber() {
        int year = dateOfJoining.get(GregorianCalendar.YEAR);
        int count = studentCount; // Use the current student count
        return Integer.parseInt("" + (year % 100) + count);
    }

    // Display student record
    void display() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Joining: " + dateOfJoining.get(GregorianCalendar.YEAR) + "-" +
                (dateOfJoining.get(GregorianCalendar.MONTH) + 1) + "-" +
                dateOfJoining.get(GregorianCalendar.DAY_OF_MONTH));
        System.out.println("Semester: " + semester);
        System.out.println("GPA: " + gpa);
        System.out.println("CGPA: " + cgpa);
        System.out.println();
    }
}

public class StudentDemoII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[5]; // Create an array for at least 5 students

        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            
            System.out.print("Full Name: ");
            String fullName = sc.nextLine();
            
            System.out.print("Date of Joining (yyyy mm dd): ");
            int year = sc.nextInt();
            int month = sc.nextInt()-1; // GregorianCalendar months are 0-based
            int day = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            GregorianCalendar dateOfJoining = new GregorianCalendar(year, month, day);
            
            System.out.print("Semester: ");
            short semester = sc.nextShort();
            
            System.out.print("GPA: ");
            float gpa = sc.nextFloat();
            
            System.out.print("CGPA: ");
            float cgpa = sc.nextFloat();
            sc.nextLine(); // Consume the newline character

            students[i] = new Student(fullName, dateOfJoining, semester, gpa, cgpa);
        }

        System.out.println("\nStudent Records:");
        for (Student student : students)
            student.display();
    }
}
