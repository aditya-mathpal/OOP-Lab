import java.util.Scanner;
class Find_sum {
	public static int findSum(int n) {
		int sum=0;
		while(n>0) {
			sum += n%10;
			n/=10;
		}
		return sum;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter number: ");
		int n = sc.nextInt();
		System.out.println("sum of digits is: " + findSum(n));
	}
}