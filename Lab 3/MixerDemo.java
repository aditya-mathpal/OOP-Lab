import java.util.Scanner;
class Mixer {
	Scanner sc = new Scanner(System.in);
	int n, i;
	int arr[] = new int[n];
	int final_arr[] = new int[];
	void accept(int x) {
		System.out.print("enter the elements of array " + (x+1) + ": ");
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt;
	}
	Mixer mix(Mixer A) {
		int i, m = this.n + A.n, p1 = 0, p2 = 0;
		final_arr[] = int[m];
		for(i=0;i<m;i++) {
			if(p1>=A.n) {
				for(i=0;i<this.n;i++)
					final_arr[i] = this.arr[p2++]
			}
			else if (p2>=this.n) {
				for(i=0;i<A.n;i++)
					final_arr[i] = A.arr[p1++]
			}
			else if(A.arr[p1] <= this.arr[p2])
				final_arr[i] = A.arr[p1++];
			else if(this.arr[p2] < A.arr[p1])
				final_arr[i] = this.arr[p2++];
		}
	}
	void display() {
		System.out.println("the elements of the merged array are:");
		int m = final_arr.length, i;
		for(i=0;i<m;i++)
			System.out.print(final_arr[i]);
	}
}