
class Student {
    private int rollNum, marks;

    public void getNumber(int num) {
        this.rollNum = num;
    }
    public void putNumber() {
        System.out.println("Roll No.: " + this.rollNum);
    }
    public void getMarks(int num) {
        this.marks = num;
    }
    public void putMarks() {
        System.out.println("Marks: " + this.marks);
    }
}

interface Sports {
    void putGrade();
}

class Result extends Student implements Sports {
    private char grade;

    public Result(int rollNum, int marks, char grade) {
        getNumber(rollNum);
        getMarks(marks);
        getGrade(grade);
        finalResult();
    }

    public void getGrade(char c) {
        this.grade = c;
    }
    public void putGrade() {
        System.out.println("Sports Grade: " + this.grade);
    }
    public void finalResult() {
        System.out.println("Final Result: ");
        super.putNumber();
        super.putMarks();
        putGrade();
    }
}

public class Main {
    public static void main(String args[]) {
        Result ob = new Result(37,100,'A');
    }
}

/*
output:
Final Result: 
Roll No.: 37
Marks: 100
Sports Grade: A
 */