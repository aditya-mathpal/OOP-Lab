package com.course.structure;

public class House extends Building {
    private int numBed, numBath;

    public House(double sqFt, int stories, int numBed, int numBath) {
        super(sqFt, stories);
        this.numBed = numBed;
        this.numBath = numBath;
        System.out.println(numBed + " bedrooms\n" + numBath + " bathrooms");
    }

    public void setNumBath(int numBath) {
        this.numBath = numBath;
    }
    public int getNumBath() {
        return numBath;
    }
    public void setNumBed(int numBed) {
        this.numBed = numBed;
    }
    public int getNumBed() {
        return numBed;
    }
}