import java.util.Scanner;

class MatrixProd {
	public static void main(String[] args) {
		System.out.print("enter dimensions of both matrices: ");
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt(), m1 = sc.nextInt(), n2 = sc.nextInt(), m2 = sc.nextInt();
		if(m1!=n2) {
			System.out.println("incompatible matrices");
			System.exit(0);
		}
		int a[][] = new int[n1][m1];
		int b[][] = new int[n2][m2];
		int c[][] = new int[n1][m2];
		System.out.print("enter elements of matrix 1 row-wise: ");
		int i, j, k;
		for(i=0;i<n1;i++)
			for(j=0;j<m1;j++)
				a[i][j] = sc.nextInt();
		System.out.print("enter elements of matrix 2 row-wise: ");
		for(i=0;i<n2;i++)
			for(j=0;j<m2;j++)
				b[i][j] = sc.nextInt();
		for(i=0;i<n1;i++)
			for(j=0;j<m2;j++)
				for(k=0;k<m1;k++)
					c[i][j] += a[i][k] * b[k][j];
		System.out.println("resultant matrix: ");
		for(i=0;i<n1;i++) {
			for(j=0;j<m2;j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}
	}
}