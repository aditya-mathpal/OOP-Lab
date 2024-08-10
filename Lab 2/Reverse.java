import java.util.Scanner;

class Reverse {
	public static void main (String[] args) {
		int i,n;
		int a[] = new int[100];
		System.out.print("enter size of array: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.print("enter elements of the array: ");
		for(i=0;i<n;i++)
			a[i] = sc.nextInt();
		int temp;
		for(i=0;i<n/2;i++) {
			temp = a[i];
			a[i] = a[n-1-i];
			a[n-1-i] = temp;
		}
		System.out.print("elements reversed are: ");
		for(i=0;i<n;i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}