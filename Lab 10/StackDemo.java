
class Stack<T> {
    private T arr[];
    private int top, size;

    Stack(int size) {
        this.size = size;
        this.arr = (T[]) new Object[size];
        this.top = -1;
    }

    public void push(T x) {
        if(top==size-1) {
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = x;
    }
    public T pop() {
        if(top==-1) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[top--];
    }
    public int getTop() {
        return top;
    }
}

class Student {
    private String name;
    private int rollNum;

    public Student(String name, int rollNum) {
        this.name = name;
        this.rollNum = rollNum;
    }
    
    public void display() {
        if(getTop()==-1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack contents: ");
        System.out.println("Name: " + this.name + "\nRoll No. " + this.rollNum);
    }
}

class Employee {
    private String name;
    private int empID;

    public Employee(String name, int empID) {
        this.name = name;
        this.empID = empID;
    }
    
    public void display() {
        System.out.println("Name: " + this.name + "\nEmployee ID: " + this.empID);
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack<Student> s = new Stack<>(1);
        Stack<Employee> e = new Stack<>(1);
        s.push(new Student("Aditya"    ,37));
        e.push(new Employee("Aditya",230905));
        s.display();    
        e.display();
    }
}

