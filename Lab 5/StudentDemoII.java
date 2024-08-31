import java.util.GregorianCalendar;
import java.util.Scanner;

class Student {
    private static int studentCount = 0;
    private int registrationNumber;
    private String fullName;
    private GregorianCalendar dateOfJoining;
    private short semester;
    private float gpa;
    private float cgpa;

    Student(String fullName, GregorianCalendar dateOfJoining, short semester, float gpa, float cgpa) {
        this.fullName = fullName;
        this.dateOfJoining = dateOfJoining;
        this.semester = semester;
        this.gpa = gpa;
        this.cgpa = cgpa;
        studentCount++;
        this.registrationNumber = generateRegNum();
    }

    private int generateRegNum() {
        int year = dateOfJoining.get(GregorianCalendar.YEAR);
        return Integer.parseInt("" + (year % 100) + studentCount);
    }

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
        Student[] students = new Student[5];

        for (int i = 0;i<students.length;i++) {
            System.out.println("Enter details for student " + (i+1) + ":");
            
            System.out.print("Full Name: ");
            String fullName = sc.nextLine();
            
            System.out.print("Date of Joining (yyyy mm dd): ");
            int year = sc.nextInt();
            int month = sc.nextInt()-1; // GregorianCalendar months are 0-indexed
            int day = sc.nextInt();
            sc.nextLine();

            GregorianCalendar dateOfJoining = new GregorianCalendar(year, month, day);
            
            System.out.print("Semester: ");
            short semester = sc.nextShort();
            
            System.out.print("GPA: ");
            float gpa = sc.nextFloat();
            
            System.out.print("CGPA: ");
            float cgpa = sc.nextFloat();
            sc.nextLine();

            students[i] = new Student(fullName, dateOfJoining, semester, gpa, cgpa);
        }
        System.out.println("\nStudent Records:");
        for (Student student : students)
            student.display();
        sc.close();
    }
}

/*
output:
Enter details for student 1:
Full Name: Aditya Mathpal
Date of Joining (yyyy mm dd): 2023 07 16
Semester: 3
GPA: 7.67
CGPA: 7.12
Enter details for student 2:
Full Name: Test Subject Zero
Date of Joining (yyyy mm dd): 2012 01 01
Semester: 4
GPA: 9 
CGPA: 9
Enter details for student 3:
Full Name: Test Subject One
Date of Joining (yyyy mm dd): 2013 01 01
Semester: 5
GPA: 9  
CGPA: 9
Enter details for student 4:
Full Name: Test Subject Two
Date of Joining (yyyy mm dd): 2014 01 01
Semester: 6
GPA: 9
CGPA: 9
Enter details for student 5:
Full Name: Test Subject Three
Date of Joining (yyyy mm dd): 2015 01 01
Semester: 7
GPA: 9 
CGPA: 9

Student Records:
Registration Number: 231
Full Name: Aditya Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 122
Full Name: Test Subject Zero
Date of Joining: 2012-1-1
Semester: 4
GPA: 9.0
CGPA: 9.0

Registration Number: 133
Full Name: Test Subject One
Date of Joining: 2013-1-1
Semester: 5
GPA: 9.0
CGPA: 9.0

Registration Number: 144
Full Name: Test Subject Two
Date of Joining: 2014-1-1
Semester: 6
GPA: 9.0
CGPA: 9.0

Registration Number: 155
Full Name: Test Subject Three
Date of Joining: 2015-1-1
Semester: 7
GPA: 9.0
CGPA: 9.0
 */