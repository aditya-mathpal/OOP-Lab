import java.util.*;

class NewThread implements Runnable {
	Thread t;
	int arr[], sum;
	NewThread(int arr[]) {
		t = new Thread(this);
		this.arr = arr;
		this.sum = 0;
	}
	public void run() {
		for(int i = 0;i<arr.length;i++) sum += arr[i];
	}
	public int getSum() {
		return sum;
	}
}

class MatrixRowSum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int matrix[][] = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0;i<rows;i++)
            for (int j = 0;j<cols;j++)
                matrix[i][j] = sc.nextInt();
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        NewThread threads[] = new NewThread[rows];

        for (int i = 0;i<rows;i++) {
            threads[i] = new NewThread(matrix[i]);
            threads[i].t.start();
        }

        int totalSum = 0;
        for (int i = 0; i < rows; i++) {
            try {
                threads[i].t.join();
                int rowSum = threads[i].getSum();
                System.out.println("Sum of row " + (i + 1) + ": " + rowSum);
                totalSum += rowSum;
            }
            catch (InterruptedException e) {}
        }

        System.out.println("Total sum of the matrix is " + totalSum);
    }
}

/*
output:
Enter the number of rows and columns: 3 3
Enter the elements of the matrix:
1 2 3 4 5 6 7 8 9
Matrix:
1 2 3 
4 5 6 
7 8 9 
Sum of row 1: 6
Sum of row 2: 15
Sum of row 3: 24
Total sum of the matrix is 45
*/