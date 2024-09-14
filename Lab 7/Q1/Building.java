package com.course.structure;

public class Building {
    private double sqFt;
    private int stories;

    public Building(double sqFt, int stories) {
        this.sqFt = sqFt;
        this.stories = stories;
        System.out.println("\nArea: " + this.sqFt + " sq. ft.\n" + this.stories + " stories");
    }

    public void setSqFt(double sqFt) {
        this.sqFt = sqFt;
    }
    public double getSqFt() {
        return sqFt;
    }
    public void setStories(int stories) {
        this.stories = stories;
    }
    public int getStories() {
        return stories;
    }
}