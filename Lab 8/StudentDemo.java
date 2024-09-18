import java.util.*;
import java.io.*;

class SeatsFilledException extends Exception {
	public SeatsFilledException() {
		super("All seats are filled.");
	}
}

class Student {
	private String name;
	private int regNum;
	Scanner sc = new Scanner(System.in);
	public void getDetails() throws SeatsFilledException {
		System.out.println("Enter student name: ");
		this.name = sc.nextLine();
		System.out.println("Enter student registration number: ");
		int x = sc.nextInt();
		if(x%100 > 25) throw new SeatsFilledException();
		this.regNum = x;
	}
	public void displayDetails() {
		System.out.println("Name: " + this.name + "\nRegistration number: " + this.regNum);
	}
}

public class StudentDemo {
	public static void main(String args[]) {
		Student s = new Student();
		boolean valid = true;
		try {
			s.getDetails();
		}
		catch(SeatsFilledException e) {
			System.out.println("Exception: " + e.getMessage());
			valid = false;
		}
		if(valid == true) s.displayDetails();
	}
}