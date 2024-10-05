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

        NewThread threads[] = new NewThread[rows];

        for (int i = 0;i<rows;i++) {
            threads[i] = new NewThread(matrix[i]);
            threads[i].t.start();
        }

        int totalSum = 0;
        for (int i = 0; i < rows; i++) {
            try {
                threads[i].t.join();
                totalSum += threads[i].getSum();
            }
            catch (InterruptedException e) {}
        }

        System.out.println("Total sum of the matrix is " + totalSum);
    }
}

/*
output:
Enter the number of rows and columns: 2 2
Enter the elements of the matrix:
1 2 3 4  
Total sum of the matrix is 10
*/