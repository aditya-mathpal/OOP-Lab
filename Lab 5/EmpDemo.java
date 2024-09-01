//Q1

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
	void compute_net_sal() {
		DA = 0.52*Basic;
		Gross_Sal = Basic + DA;
		IT = 0.3*Gross_Sal;
		Net_Sal = Gross_Sal - IT;
	}
	//additions from here till end of class:
	void formatEmployeeName() {
		String words[] = this.Ename.split(" ");
		String updatedName = "";
		for(String word:words) {
			String temp = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
			updatedName += temp + " ";
		}
		this.Ename = updatedName.trim();
	}
	String generateEmail() {
		String words[] = this.Ename.split(" ");
		String email = "";
		int i, len = words.length;
		for(i=0;i<len-1;i++)
			email += Character.toLowerCase(words[i].charAt(0));
		email += words[len-1].toLowerCase() + "@example.com";
		return email;
	}
	void display() { //added email
		System.out.println("Name: " + Ename + "\nEmployee ID: " + Eid + "\nEmail address: " + generateEmail() + "\nNet Salary: " + Net_Sal);
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
			e[i].formatEmployeeName();//added
		}
		for(i=0;i<n;i++)
			e[i].display();
		sc.close();
	}
}

/*
output:
enter number of employees: 1
enter employee 1 name: aDitYA paNKAJ matHpal
enter employee ID: 230905   
enter basic: 50000

Name: Aditya Pankaj Mathpal
Employee ID: 230905
Email address: apmathpal@example.com
Net Salary: 53200.0
*/