import java.util.Scanner;

class max {
	public static int max(int a, int b, int c) {
		if(a>=b && a>=c) return a;
		else if(b>=a && b>=c) return b;
		else return c;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a, b, c: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println("largest is " + max(a,b,c));
	}
}