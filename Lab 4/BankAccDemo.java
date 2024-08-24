import java.util.*;
class BankAcc {
	Scanner sc = new Scanner(System.in);
	String name, accNum, accType;
	double bal;
	static double roi = 5;
	BankAcc() {}
	BankAcc(String name_, String num, String type, double balance) {
		name = name_;
		accNum = num;
		accType = type;
		bal = balance;
	}
	void deposit(int amt) {
		bal += amt;
	}
	void withdraw() {
		System.out.println("Account balance is "+bal+", "+(bal-1000)+" over minimum balance.\nMaximum withdrawal can be "+(bal-1000)+".\nEnter withdrawal amount: ");
		int n = sc.nextInt();
		if(n>(bal-1000)) {
			System.out.println("Insufficient funds");
			return;
		}
		else {
			bal -= n;
			System.out.println(n+" INR have been withdrawn.");
		}
	}
	void display() {
		System.out.println("Account holder name: "+name+"\nAccount number: "+accNum+"\nAccount Type: "+accType+"\nBalance: "+bal+"\n");
	}
	void displayRoi() {
		System.out.println("The rate of interest is "+roi);
	}
}

class BankAccDemo {
	public static void main(String Args[]) {
		Scanner sc = new Scanner(System.in);
		BankAcc b1 = new BankAcc();
		BankAcc b2 = new BankAcc("A","230905","Savings",100000);
		b1.display();
		b2.display();
		while(true) {
			System.out.print("Mr A, enter 1 to deposit, 2 to withdraw, 3 to display bank details, 4 to display rate of interest, 5 to exit: ");
			int c = sc.nextInt();
			switch(c) {
			case 1:
				System.out.println("Enter amount to deposit: ");
				b2.deposit(sc.nextInt());
				break;
			case 2:
				b2.withdraw();
				break;
			case 3:
				b2.display();
				break;
			case 4:
				b2.displayRoi();
				break;
			case 5:
				return;
			}
		}
	}
}
/*
Account holder name: null
Account number: null
Account Type: null
Balance: 0.0

Account holder name: A
Account number: 230905
Account Type: Savings
Balance: 100000.0

Mr A, enter 1 to deposit, 2 to withdraw, 3 to display bank details, 4 to display rate of interest, 5 to exit: 1
Enter amount to deposit: 
5000
Mr A, enter 1 to deposit, 2 to withdraw, 3 to display bank details, 4 to display rate of interest, 5 to exit: 2
Account balance is 105000.0, 104000.0 over minimum balance.
Maximum withdrawal can be 104000.0.
Enter withdrawal amount: 
4000
4000 INR have been withdrawn.
Mr A, enter 1 to deposit, 2 to withdraw, 3 to display bank details, 4 to display rate of interest, 5 to exit: 3
Account holder name: A
Account number: 230905
Account Type: Savings
Balance: 101000.0

Mr A, enter 1 to deposit, 2 to withdraw, 3 to display bank details, 4 to display rate of interest, 5 to exit: 4
The rate of interest is 5.0
*/