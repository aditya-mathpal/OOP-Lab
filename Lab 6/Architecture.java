class Building {
    private double sqFt;
    private int stories;

    Building(double sqFt, int stories) {
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

class House extends Building {
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

class School extends Building {
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

public class Architecture {
    public static void main(String args[]) {
        new Building(2000, 10);
        new House(500, 10, 3, 3);
        new School(2000, 5, 150, "Elementary");
    }
}

/*
output:
Area: 2000.0 sq. ft.
10 stories

Area: 500.0 sq. ft.
10 stories
3 bedrooms
3 bathrooms

Area: 2000.0 sq. ft.
5 stories
150 classrooms
Elementary school
 */