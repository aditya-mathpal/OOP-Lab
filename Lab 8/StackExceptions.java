import java.util.*;
import java.io.*;

class PushException extends Exception {
	public PushException() {
		super("Stack is full.");
	}
}

class PopException extends Exception {
    public PopException() {
        super("Stack is empty.");
    }
}

class Stack {
	private int arr[];
	private int top;

	public Stack() {
		this.arr = new int[10];
		this.top = -1;
	}

	public boolean isFull() {
		return top == arr.length-1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int x) throws PushException {
		if(isFull()) throw new PushException();
		arr[++top] = x;
	}

	public int pop() throws PopException {
		if(isEmpty()) throw new PopException();
		return arr[top--];
	}

	public void display() throws PopException {
		if(isEmpty()) throw new PopException();
		System.out.println("The stack is:");
		int i;
		for(i=top;i>=0;i--) System.out.println(arr[i]);
	}
}

public class StackExceptions {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Stack s = new Stack();
		String str;
		while(true) {
			try {
				System.out.println("Enter operation: push, pop, display, or exit");
				str = sc.nextLine();
				switch(str) {
				case "push":
					System.out.print("Enter number to push: ");
					s.push(sc.nextInt());
					sc.nextLine();
					System.out.println("Pushed.");
					break;
				case "pop":
					System.out.println(s.pop() + " popped.");
					break;
				case "display":
					s.display();
					break;
				case "exit":
					return;
				}
			}
			catch (PushException e) {
			System.out.println("Exception: " + e.getMessage());
			}
			catch (PopException e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
	}
}

/*
output:
Enter operation: push, pop, display, or exit
pop   
Exception: Stack is empty.
Enter operation: push, pop, display, or exit
exit
*/