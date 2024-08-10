import java.util.Scanner;

class Prime {
	public static boolean isPrime(int num) {
		int i;
		if(num<2) return false;
		for(i=2;i*i<=num;i++)
			if(num%i==0) return false;
		return true;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter how many prime numbers to be printed: ");
		int n = sc.nextInt();
		int i=1;
		while(n>0) {
			if(isPrime(i)) {
				System.out.print(i+" ");
				n--;
			}
			i++;
		}
	}
}