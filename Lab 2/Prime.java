import java.util.Scanner;

class Prime {
	public static boolean isPrime(int n) {
		int i;
		if(n<2) return false;
		for(i=2;i*i<=n;i++)
			if(n%i==0) return false;
		return true;
	}
	public static void main(String[] args) {
		int i, n;
		Scanner sc = new Scanner(System.in);
		System.out.print("enter size of array: ");
		n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("enter elements of the array: ");
		for(i=0;i<n;i++)
			a[i] = sc.nextInt();
		System.out.print("the prime numbers are: ");
		for(i=0;i<n;i++)
			if(isPrime(a[i])) System.out.print(a[i]+" ");
		System.out.println();
	}
}