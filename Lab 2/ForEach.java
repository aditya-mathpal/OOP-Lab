import java.util.Scanner;

class ForEach {
	public static void main (String[] args) {
		int i,n;
		System.out.print("enter size of array: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int a[] = new int[n];
		System.out.print("enter elements of the array: ");
		for(i=0;i<n;i++)
			a[i] = sc.nextInt();
		for(int j:a)
			System.out.print(j + " ");
		System.out.println(" ");
	}
}