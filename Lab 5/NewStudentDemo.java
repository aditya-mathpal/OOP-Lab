//3-5 New Student Class

import java.util.GregorianCalendar;
import java.util.Scanner;

//3
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

    //4
    short getSemester() {
        return semester;
    }

    float getCgpa() {
        return cgpa;
    }

    String getFullName() {
        return fullName;
    }

    void setFullName(String fullName) { //Q5 addition
        this.fullName = fullName;
    }

    static void sortBySemesterAndCgpa(Student[] students) {
        for (int i=0;i<students.length-1;i++) {
            for (int j=i+1;j<students.length;j++) {
                if (students[i].getSemester() > students[j].getSemester() || 
                   (students[i].getSemester() == students[j].getSemester() && students[i].getCgpa() < students[j].getCgpa())) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    static void sortByName(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getFullName().compareTo(students[j].getFullName()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
    //5
    static void listStudentsByInitial(Student[] students, char initial) {
        System.out.println("\nStudents whose name starts with '" + initial + "':");
        for (Student student : students) {
            if (student.getFullName().charAt(0) == initial) {
                student.display();
            }
        }
    }

    static void listStudentsBySubstring(Student[] students, String substring) {
        System.out.println("\nStudents whose name contains '" + substring + "':");
        for (Student student : students) {
            if (student.getFullName().toLowerCase().contains(substring)) {
                student.display();
            }
        }
    }

    void convertNameToInitials() {
        String[] nameParts = fullName.split(" ");
        StringBuilder newName = new StringBuilder();

        for (int i = 0; i < nameParts.length - 1; i++) {
            newName.append(nameParts[i].charAt(0)).append(". ");
        }

        newName.append(nameParts[nameParts.length - 1]);
        this.fullName = newName.toString();
    }
}

public class NewStudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //3
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

        //4
        Student.sortBySemesterAndCgpa(students);
        System.out.println("\nStudent Records (Sorted by Semester and CGPA):");
        for (Student student : students)
            student.display();

        Student.sortByName(students);
        System.out.println("\nStudent Records (Sorted by Name):");
        for (Student student : students)
            student.display();

        //5
        System.out.print("\nEnter initial to list students: ");
        char initial = sc.next().charAt(0);
        Student.listStudentsByInitial(students, initial);

        System.out.print("\nEnter substring to list students: ");
        sc.nextLine();
        String substring = sc.nextLine();
        Student.listStudentsBySubstring(students, substring);

        for (Student student : students) {
            student.convertNameToInitials();
        }

        System.out.println("\nStudent Records (Modified to Initials):");
        for (Student student : students)
            student.display();
        
        sc.close();
    }
}

/*
output:
//3
Enter details for student 1:
Full Name: Aditya Mathpal
Date of Joining (yyyy mm dd): 2023 07 16
Semester: 3
GPA: 7.67
CGPA: 7.12
Enter details for student 2:
Full Name: Bhavya Sharma
Date of Joining (yyyy mm dd): 2022 08 25
Semester: 5
GPA: 8.54
CGPA: 8.23
Enter details for student 3:
Full Name: Chirag Gupta
Date of Joining (yyyy mm dd): 2023 01 10
Semester: 3
GPA: 7.91
CGPA: 7.56
Enter details for student 4:
Full Name: Deepika Singh
Date of Joining (yyyy mm dd): 2021 09 12
Semester: 7
GPA: 9.02
CGPA: 8.75
Enter details for student 5:
Full Name: Aayushi Verma
Date of Joining (yyyy mm dd): 2023 05 03
Semester: 3
GPA: 7.67
CGPA: 7.12

Student Records:
Registration Number: 231
Full Name: Aditya Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 222
Full Name: Bhavya Sharma
Date of Joining: 2022-8-25
Semester: 5
GPA: 8.54
CGPA: 8.23

Registration Number: 233
Full Name: Chirag Gupta
Date of Joining: 2023-1-10
Semester: 3
GPA: 7.91
CGPA: 7.56

Registration Number: 214
Full Name: Deepika Singh
Date of Joining: 2021-9-12
Semester: 7
GPA: 9.02
CGPA: 8.75

Registration Number: 235
Full Name: Aayushi Verma
Date of Joining: 2023-5-3
Semester: 3
GPA: 7.67
CGPA: 7.12


Student Records (Sorted by Semester and CGPA):
Registration Number: 233
Full Name: Chirag Gupta
Date of Joining: 2023-1-10
Semester: 3
GPA: 7.91
CGPA: 7.56

Registration Number: 231
Full Name: Aditya Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 235
Full Name: Aayushi Verma
Date of Joining: 2023-5-3
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 222
Full Name: Bhavya Sharma
Date of Joining: 2022-8-25
Semester: 5
GPA: 8.54
CGPA: 8.23

Registration Number: 214
Full Name: Deepika Singh
Date of Joining: 2021-9-12
Semester: 7
GPA: 9.02
CGPA: 8.75


Student Records (Sorted by Name):
Registration Number: 235
Full Name: Aayushi Verma
Date of Joining: 2023-5-3
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 231
Full Name: Aditya Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 222
Full Name: Bhavya Sharma
Date of Joining: 2022-8-25
Semester: 5
GPA: 8.54
CGPA: 8.23

Registration Number: 233
Full Name: Chirag Gupta
Date of Joining: 2023-1-10
Semester: 3
GPA: 7.91
CGPA: 7.56

Registration Number: 214
Full Name: Deepika Singh
Date of Joining: 2021-9-12
Semester: 7
GPA: 9.02
CGPA: 8.75


Enter initial to list students: A

Students whose name starts with 'A':
Registration Number: 235
Full Name: Aayushi Verma
Date of Joining: 2023-5-3
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 231
Full Name: Aditya Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12


Enter substring to list students: ma

Students whose name contains 'ma':
Registration Number: 235
Full Name: Aayushi Verma
Date of Joining: 2023-5-3
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 231
Full Name: Aditya Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 222
Full Name: Bhavya Sharma
Date of Joining: 2022-8-25
Semester: 5
GPA: 8.54
CGPA: 8.23


Student Records (Modified to Initials):
Registration Number: 235
Full Name: A. Verma
Date of Joining: 2023-5-3
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 231
Full Name: A. Mathpal
Date of Joining: 2023-7-16
Semester: 3
GPA: 7.67
CGPA: 7.12

Registration Number: 222
Full Name: B. Sharma
Date of Joining: 2022-8-25
Semester: 5
GPA: 8.54
CGPA: 8.23

Registration Number: 233
Full Name: C. Gupta
Date of Joining: 2023-1-10
Semester: 3
GPA: 7.91
CGPA: 7.56

Registration Number: 214
Full Name: D. Singh
Date of Joining: 2021-9-12
Semester: 7
GPA: 9.02
CGPA: 8.75
 */