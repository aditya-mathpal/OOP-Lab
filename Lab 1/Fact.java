import java.util.Scanner;

class Fact{
	public static int fact(int num) {
		if(num==1) return 1;
		else return num*fact(num-1);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter n and r to compute nCr: ");
		int n = sc.nextInt();
		int r = sc.nextInt();
		int nCr = fact(n)/(fact(r)*fact(n-r));
		System.out.println("nCr = "+nCr);
	}
}