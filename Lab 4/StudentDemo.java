class Student {
	String sname;
	double[] marks_array = new double[3];
	double total, avg;
	Student() {}
	Student(String name, double arr[]) {
		sname = name;
		marks_array = arr;
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
		Student s1 = new Student();
		double marks[] = {50,60,70};
		Student s2 = new Student("A",marks);
		s1.compute();
		s2.compute();
		s1.display();
		s2.display();
	}
}

/*
output:
Name : null
marks:
Subject 1: 0.0
Subject 2: 0.0
Subject 3: 0.0
Total marks: 0.0
avg marks: 0.0

Name : A
marks:
Subject 1: 50.0
Subject 2: 60.0
Subject 3: 70.0
Total marks: 180.0
avg marks: 60.0
*/