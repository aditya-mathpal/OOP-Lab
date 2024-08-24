class Employee {
	String Ename, Eid;
	double Basic, DA, Gross_Sal, Net_Sal, IT;
	Employee() {}
	Employee(String name, String ID, double Base) {
		Ename = name;
		Eid = ID;
		Basic = Base;
	}
	void display() {
		System.out.println("Name: " + Ename + "\nEmployee ID: " + Eid + "\nNet Salary: " + Net_Sal);
	}
	void compute_net_sal() {
		DA = 0.52*Basic;
		Gross_Sal = Basic + DA;
		IT = 0.3*Gross_Sal;
		Net_Sal = Gross_Sal - IT;
	}
}

class EmpDemo {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee("A","230905",100000);
		e1.compute_net_sal();
		e2.compute_net_sal();
		e1.display();
		e2.display();
	}
}

/*
output:
Name: null
Employee ID: null
Net Salary: 0.0
Name: A
Employee ID: 230905
Net Salary: 106400.0
*/