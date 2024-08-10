import java.util.Scanner;

class MatrixAdd {
	public static void main(String[] args) {
		System.out.print("enter dimensions of both matrices: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int a[][] = new int[n][m];
		int b[][] = new int[n][m];
		System.out.print("enter elements of matrix 1 row-wise: ");
		int i, j;
		for(i=0;i<n;i++)
			for(j=0;j<m;j++)
				a[i][j] = sc.nextInt();
		System.out.print("enter elements of matrix 2 row-wise: ");
		for(i=0;i<n;i++)
			for(j=0;j<m;j++)
				b[i][j] = sc.nextInt();
		int c[][] = new int[n][m];
		for(i=0;i<n;i++)
			for(j=0;j<m;j++)
				c[i][j] = a[i][j] + b[i][j];
		System.out.println("resultant matrix: ");
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}
	}
}