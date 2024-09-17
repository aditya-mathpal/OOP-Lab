class Student {
    private String name, ID;

    public Student(String name, String iD) {
        this.name = name;
        ID = iD;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getID() {
        return ID;
    }
}

class Sports extends Student {
    private int s_grade;

    public Sports(String name, String iD, int s_grade) {
        super(name, iD);
        this.s_grade = s_grade;
    }

    public void setS_grade(int s_grade) {
        this.s_grade = s_grade;
    }
    public int getS_grade() {
        return s_grade;
    }
}

class Exam extends Student {
    private int e_grade;
    
    public Exam(String name, String iD, int e_grade) {
        super(name, iD);
        this.e_grade = e_grade;
    }

    public void setE_grade(int e_grade) {
        this.e_grade = e_grade;
    }
    public int getE_grade() {
        return e_grade;
    }
}

class Results {
    Sports s;
    Exam e;
    String str;

    public Results(Sports s, Exam e) {
        this.s = s;
        this.e = e;
        calculateFinalResult();
        displayFinalResult();
    }

    public void calculateFinalResult() {
        if(s.getS_grade()>=35 && e.getE_grade()>=35) str = "Pass";
        else str = "Fail";
    }

    public void displayFinalResult() {
        System.out.println(str);
    }

}

public class YetAnotherStudentClass {
    public static void main(String[] args) {
        Sports s = new Sports("Aditya","230905",80);
        Exam e = new Exam("Aditya","230905",90);
        new Results(s,e);
    }
}

/*
output:
Pass
 */