//Q2

import java.util.Scanner;

class Student {
	Scanner sc = new Scanner(System.in);
	String sname;
	double[] marks_array = new double[3];
	double total, avg;
	int i,j;
	void assign(int n) {
		System.out.print("enter name of student " + (n+1) + ": ");
		sname = sc.nextLine();
		System.out.print("enter marks of all 3 subjects: ");
		for(i=0;i<3;i++)
			marks_array[i] = sc.nextDouble();
	}
	void display() {
		System.out.println("Name : " + sname + "\nmarks:");
		for(i=0;i<3;i++)
			System.out.println("Subject " + (i+1) + ": "+ marks_array[i]);
		System.out.println("Total marks: " + total + "\navg marks: " + avg + "\n");
	}
	void compute() {
		total = 0;
		for(i=0;i<3;i++)
			total += marks_array[i];
		avg = total/3;
	}
	//addtions from here till end of class
    String extractInitials() {
        String[] words = sname.split(" ");
        String initials = "";
        for (String word : words)
            initials += Character.toUpperCase(word.charAt(0));
        return initials;
    }
    String removeWhitespace() {
        return sname.replaceAll(" ", "");
    }
    static int countNamesContaining(Student[] students, String substring) {
        int count = 0;
        for (Student student : students)
            if (student.sname.contains(substring)) count++;
        return count;
    }

    static String[] getNamesContaining(Student[] students, String substring) {
        int count = countNamesContaining(students,substring);
        String[] result = new String[count];
        int index = 0;
        for (Student student : students) {
            if (student.sname.contains(substring)) {
                result[index++] = student.sname;
            }
        }
        return result;
    }

    static void sortStudents(Student[] students) {
        int n = students.length,i,j;
        for (i=0;i<n-1;i++) {
            for (j=0;j<n-i-1;j++) {
                if (students[j].sname.compareTo(students[j+1].sname)>0) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
    }
}

class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number of students: ");
		int n = sc.nextInt();
		sc.nextLine();
		Student s[] = new Student[n];
		int i;
		for(i=0;i<n;i++) {
			s[i] = new Student();
			s[i].assign(i);
			s[i].compute();
		}
		//additions from here till end of class
        Student.sortStudents(s);
		for(i=0;i<n;i++)
			s[i].display();
        System.out.println("Initials of each student:");
        for (Student student : s) {
            System.out.println(student.extractInitials());
        }
        System.out.println("Student names with whitespace removed:");
        for (Student student : s)
            System.out.println(student.removeWhitespace());
        System.out.print("Enter substring to search for: ");
        String substring = sc.nextLine();
        String[] namesContainingSubstring = Student.getNamesContaining(s, substring);
        System.out.println("Students with names containing \"" + substring + "\":");
        for (String name : namesContainingSubstring)
            System.out.println(name);
        sc.close();
	}
}
/*
output:
enter number of students: 2
enter name of student 1: Aditya Mathpal
enter marks of all 3 subjects: 8 8 8
enter name of student 2: Test Subject
enter marks of all 3 subjects: 5 5 5
Name : Aditya Mathpal
marks:
Subject 1: 8.0
Subject 2: 8.0
Subject 3: 8.0
Total marks: 24.0
avg marks: 8.0

Name : Test Subject
marks:
Subject 1: 5.0
Subject 2: 5.0
Subject 3: 5.0
Total marks: 15.0
avg marks: 5.0

Initials of each student:
AM
TS
Student names with whitespace removed:
AdityaMathpal
TestSubject
Enter substring to search for: ty
Students with names containing "ty":
Aditya Mathpal
*/