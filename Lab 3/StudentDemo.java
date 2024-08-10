import java.util.Scanner;

class Student {
	Scanner sc = new Scanner(System.in);
	String sname;
	double[] marks_array = new double[3];
	double total, avg;
	void assign(int n) {
		System.out.print("enter name of student " + (n+1) + ": ");
		sname = sc.nextLine();
		System.out.print("enter marks of all 3 subjects: ");
		int i;
		for(i=0;i<3;i++)
			marks_array[i] = sc.nextDouble();
	}
	void display() {
		System.out.println("Name : " + sname + "\nmarks:");
		int i;
		for(i=0;i<3;i++)
			System.out.println("Subject " + (i+1) + ": "+ marks_array[i]);
		System.out.println("Total marks: " + total + "\navg marks: " + avg + "\n");
	}
	void compute() {
		total = 0;
		int i;
		for(i=0;i<3;i++)
			total += marks_array[i];
		avg = total/3;
	}
}

class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number of students: ");
		int n = sc.nextInt();
		Student s[] = new Student[n];
		int i;
		for(i=0;i<n;i++) {
			s[i] = new Student();
			s[i].assign(i);
			s[i].compute();
		}
		for(i=0;i<n;i++)
			s[i].display();
	}
}
/*
output:
enter number of students: 3
enter name of student 1: A
enter marks of all 3 subjects: 3 4 5
enter name of student 2: B
enter marks of all 3 subjects: 4 5 6
enter name of student 3: C
enter marks of all 3 subjects: 5 6 7
Name : A
marks:
Subject 1: 3.0
Subject 2: 4.0
Subject 3: 5.0
Total marks: 12.0
avg marks: 4.0

Name : B
marks:
Subject 1: 4.0
Subject 2: 5.0
Subject 3: 6.0
Total marks: 15.0
avg marks: 5.0

Name : C
marks:
Subject 1: 5.0
Subject 2: 6.0
Subject 3: 7.0
Total marks: 18.0
avg marks: 6.0
*/