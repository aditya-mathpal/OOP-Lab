class Student {
	private String sname;
	private double[] marks_array = new double[3];
	private double total, avg;
	Student(String name, double arr[]) {
		this.sname = name;
		this.marks_array = arr;
	}
	void display() {
		System.out.println("Name: " + sname + "\nmarks:");
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
	String getName() {
		return sname;
	}
	void setName(String sname) {
		this.sname = sname;
	}
	double getTotal() {
		return total;
	}
	void setTotal(double total) {
		this.total = total;
	}

}

class ScienceStudent extends Student {
	private int practicalMarks;
	private double total, avg;
	ScienceStudent(String name, double arr[], int practicalMarks) {
		super(name,arr);
		this.practicalMarks = practicalMarks;
	}
	@Override
	void compute() {
		super.compute();
		this.total += getTotal() + this.practicalMarks;
		this.avg = this.total/4;
	}
	void displayPracticalMarks() {
		System.out.println("Name: " + getName() + "\nPractical marks: " + this.practicalMarks + "\n");
	}
}

class ArtsStudent extends Student {
	private String electiveSubject;
	ArtsStudent(String name, double arr[], String electiveSubject) {
		super(name,arr);
		this.electiveSubject = electiveSubject;
	}
	void displayElectiveSubject() {
		System.out.println(getName() + "'s elective subject is: "+this.electiveSubject);
	}
}

class StudentDemo {
	public static void main(String args[]) {
		double[] sMarks = {50,60,70}, ssMarks = {40,50,60}, asMarks = {60,70,80};
		Student s = new Student("Aditya Mathpal",sMarks);
		ScienceStudent ss = new ScienceStudent("Saanvi Rao",ssMarks,100);
		ArtsStudent as = new ArtsStudent("Arjun Patel",asMarks,"Sociology");
		s.compute();
		s.display();
		ss.compute();
		ss.display();
		ss.displayPracticalMarks();
		as.displayElectiveSubject();
	}
}

/*
output:
Name: Aditya Mathpal
marks:
Subject 1: 50.0
Subject 2: 60.0
Subject 3: 70.0
Total marks: 180.0
avg marks: 60.0

Name: Saanvi Rao
marks:
Subject 1: 40.0
Subject 2: 50.0
Subject 3: 60.0
Total marks: 150.0
avg marks: 50.0

Name: Saanvi Rao
Practical marks: 100

Arjun Patel's elective subject is: Sociology
*/