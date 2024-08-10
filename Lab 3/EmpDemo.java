import java.util.Scanner;
class Employee {
	Scanner sc = new Scanner(System.in);
	String Ename, Eid;
	double Basic, DA, Gross_Sal, Net_Sal, IT;
	void read(int n) {
		System.out.print("enter employee " + (n+1) + " name: ");
		Ename = sc.nextLine();
		System.out.print("enter employee ID: ");
		Eid = sc.nextLine();
		System.out.print("enter basic: ");
		Basic = sc.nextDouble();
		System.out.println();
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
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number of employees: ");
		int n = sc.nextInt();
		Employee e[] = new Employee[n];
		int i;
		for(i=0;i<n;i++) {
			e[i] = new Employee();
			e[i].read(i);
			e[i].compute_net_sal();
		}
		for(i=0;i<n;i++)
			e[i].display();
	}
}

/*
output:
enter number of employees: 3
enter employee 1 name: A
enter employee ID: abc
enter basic: 50

enter employee 2 name: B
enter employee ID: bcd
enter basic: 60

enter employee 3 name: C
enter employee ID: cde
enter basic: 70

Name: A
Employee ID: abc
Net Salary: 53.2
Name: B
Employee ID: bcd
Net Salary: 63.84
Name: C
Employee ID: cde
Net Salary: 74.48
*/