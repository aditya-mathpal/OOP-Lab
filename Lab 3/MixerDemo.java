import java.util.Scanner;
class Mixer {
	Scanner sc = new Scanner(System.in);
	int n, i;
	int arr[];
	
	Mixer(int size) {
		n = size;
		arr = new int[n];
	}
	
	void accept(int x) {
		System.out.print("enter the elements of array " + x + ": ");
		for(i=0;i<n;i++)
			arr[i] = sc.nextInt();
	}
	
	Mixer mix(Mixer A) {
		int i=0, m = this.n + A.n, p1 = 0, p2 = 0;
		int final_arr[] = new int[m];
		while (p1 < this.n && p2 < A.n) { //while both arrays have content
            if (this.arr[p1] < A.arr[p2]) {
                if (i == 0 || final_arr[i - 1] != this.arr[p1]) {
                    final_arr[i++] = this.arr[p1];
                }
                p1++;
            } else if (this.arr[p1] > A.arr[p2]) {
                if (i == 0 || final_arr[i - 1] != A.arr[p2]) {
                    final_arr[i++] = A.arr[p2];
                }
                p2++;
            } else {
                if (i == 0 || final_arr[i - 1] != this.arr[p1]) {
                    final_arr[i++] = this.arr[p1];
                }
                p1++;
                p2++;
            }
        }

        while (p1 < this.n) {
            if (i == 0 || final_arr[i - 1] != this.arr[p1]) {
                final_arr[i++] = this.arr[p1];
            }
            p1++;
        }

        while (p2 < A.n) {
            if (i == 0 || final_arr[i - 1] != A.arr[p2]) {
                final_arr[i++] = A.arr[p2];
            }
            p2++;
        }
        this.n = i;
        this.arr = new int[i];
        for (int j = 0; j < i; j++)
            this.arr[j] = final_arr[j];
        return this;
    }
    
	void display() {
		System.out.print("the elements of the merged array are: ");
		int m = arr.length, i;
		for(i=0;i<m;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}

class MixerDemo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.print("enter size of array 1: ");
		n = sc.nextInt();
		Mixer mixer1 = new Mixer(n);
        mixer1.accept(1);
        
        System.out.print("enter size of array 2: ");
		n = sc.nextInt();
        Mixer mixer2 = new Mixer(n);
        mixer2.accept(2);
        
        Mixer result = mixer1.mix(mixer2);
        result.display();
    }
}

/*
output:
enter size of array 1: 3
enter the elements of array 1: 1 2 2
enter size of array 2: 3
enter the elements of array 2: 2 2 3
the elements of the merged array are: 1 2 3
*/

