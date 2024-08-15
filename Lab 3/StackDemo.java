import java.util.Scanner;
class Stack {
	int tos,max;
	int arr[];
	void initialize() {
		tos = -1;
	}
	void push(int ele) {
		if(tos>=max-1) {
			System.out.println("Stack overflow");
			return;
		}
		arr[++tos] = ele;
	}
	int pop() {
		if(tos<0) {
			System.out.println("Stack underflow");
			return 0;
		}
		return arr[tos--];
	}
	void display() {
		System.out.print("Stack contents: ");
		if(tos<0) {
			System.out.println("Null");
			return;
		}
		int i;
		for(i=tos;i>=0;i--)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

class StackDemo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		System.out.print("Enter size of stack: ");
		s.max = sc.nextInt();
		s.arr = new int[s.max];
		s.initialize();
		while(true) {
			System.out.print("enter 1 to push, 2 to pop, 3 to display stack: ");
			int x = sc.nextInt();
			switch(x) {
				case 1: {
					System.out.print("enter element to push to top of stack: ");
					s.push(sc.nextInt());
				}
				break;
				case 2: System.out.println(s.pop() + " popped");
				break;
				case 3: s.display();
				break;
				default: System.out.println("please enter a valid input");
			}
		}
	}
}

/*
Enter size of stack: 5
enter 1 to push, 2 to pop, 3 to display stack: 1
enter element to push to top of stack: 34
enter 1 to push, 2 to pop, 3 to display stack: 3
Stack contents: 34 
enter 1 to push, 2 to pop, 3 to display stack: 2
34 popped
enter 1 to push, 2 to pop, 3 to display stack: 3
Stack contents: Null
*/
