class Employee {
	private String Ename, Eid;
	private double Basic, DA, Gross_Sal, Net_Sal, IT;
	Employee() {}
	Employee(String name, String ID, double Base) {
		Ename = name;
		Eid = ID;
		Basic = Base;
	}
	void displayEmployeeDetails() {
		System.out.println("Name: " + Ename + "\nEmployee ID: " + Eid + "\nNet Salary: " + Net_Sal + "\n");
	}
	void calculateSalary() {
		DA = 0.52*Basic;
		Gross_Sal = Basic + DA;
		IT = 0.3*Gross_Sal;
		Net_Sal = Gross_Sal - IT;
	}
	double getNetSal() {
		return this.Net_Sal;
	}
	void setNetSal(double Net_Sal) {
		this.Net_Sal = Net_Sal;
	}
	String getEname() {
		return this.Ename;
	}
	void setEname(String name) {
		this.Ename = name;
	}
	String getEid() {
		return this.Eid;
	}
	void setEid(String Eid) {
		this.Eid = Eid;
	}
	double getBasic() {
		return this.Basic;
	}
	void setBasic(double basic) {
		this.Basic = basic;
	}
}

//added class
class FullTimeEmp extends Employee {
	private double bonus, deductions;
	FullTimeEmp(String name, String ID, double basic, double bonus, double deductions) {
		super(name, ID, basic);
		this.bonus = bonus;
		this.deductions = deductions;
	}
	void calculateSalary() {
		setNetSal(1.064*getBasic() + bonus - deductions);
	}
	void displayEmployeeDetails() {
		System.out.println("Name: " + getEname() + "\nEmployee ID: " + getEid() + "\nNet Salary: " + getNetSal() + "\n");
	}
}

//added class
class PartTimeEmp extends Employee {
	private int hoursWorked;
	private static final double hourlyRate = 1000;
	PartTimeEmp(String name, String ID, double basic, int hoursWorked) {
		super(name, ID, basic);
		this.hoursWorked = hoursWorked;
	}
	void calculateSalary() {
		setNetSal(this.hoursWorked * hourlyRate);
	}
	void displayEmployeeDetails() {
		System.out.println("Name: " + getEname() + "\nEmployee ID: " + getEid() + "\nNet Salary: " + getNetSal() + "\nHours Worked: " + this.hoursWorked + "\nHourly Rate: " + hourlyRate + "\n");
	}
}

class EmpDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee("A","230905",100000);
		FullTimeEmp e2 = new FullTimeEmp("B","230906",120000,20000, 2000);
		PartTimeEmp e3 = new PartTimeEmp("C","230907",0,50);

		e1.calculateSalary();
		e1.displayEmployeeDetails();
		
		e2.calculateSalary();
		e2.displayEmployeeDetails();

		e3.calculateSalary();
		e3.displayEmployeeDetails();
	}
}

/*
output:
Name: A
Employee ID: 230905
Net Salary: 106400.0

Name: B
Employee ID: 230906
Net Salary: 145680.0

Name: C
Employee ID: 230907
Net Salary: 50000.0
Hours Worked: 50
Hourly Rate: 1000.0

*/