import java.util.*;
import java.io.*;

class InvalidDayException extends Exception {
	public InvalidDayException() {
		super("Invalid day entered.");
	}
}

class InvalidMonthException extends Exception {
	public InvalidMonthException() {
		super("Invalid month entered.");
	}
}

class CurrentDate {
	private int day, month, year;
	boolean isValid = false;
	Scanner sc = new Scanner(System.in);
	public void createDate() throws InvalidDayException, InvalidMonthException {
		System.out.print("Enter day: ");
		int x = sc.nextInt();
		if(x>31) throw new InvalidDayException();
		else isValid = true;
		this.day = x;
		System.out.print("Enter month: ");
		x = sc.nextInt();
		if(x>12) throw new InvalidMonthException();
		else isValid = true;
		this.month = x;
		System.out.print("Enter year: ");
		this.year = sc.nextInt();
	}
	public void displayDate() {
		if(isValid) {
			System.out.println("Date entered is " + this.day + "-" + this.month + "-" + this.year);
		}
	}
}

public class CurrentDateDemo {
	public static void main(String args[]) {
		CurrentDate d = new CurrentDate();
		try {
			d.createDate();
			d.displayDate();
		}
		catch(InvalidDayException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		catch(InvalidMonthException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}

/*
output:
Enter day: 31
Enter month: 13
Exception: Invalid month entered.
*/