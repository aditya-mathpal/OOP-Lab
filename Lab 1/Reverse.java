import java.util.Scanner;

class Reverse {
	public static int rev(int n) {
		int rev=0;
		for(;n>0;rev=10*rev+n%10,n/=10);
		return rev;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number to check if it's a palindrome: ");
		int a = sc.nextInt();
		if(rev(a) == a) System.out.println("palindrome");
		else System.out.println("not palindrome");
	}
}