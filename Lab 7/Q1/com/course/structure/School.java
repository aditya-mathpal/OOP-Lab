package com.course.structure;

public class School extends Building {
    private int numClass;
    private String grade;

    public School(double sqFt, int stories, int numClass, String grade) {
        super(sqFt, stories);
        this.numClass = numClass;
        this.grade = grade;
        System.out.println(numClass + " classrooms\n" + grade + " school");
    }

    public void setNumClass(int numClass) {
        this.numClass = numClass;
    }
    public int getNumClass() {
        return numClass;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getGrade() {
        return grade;
    }
}