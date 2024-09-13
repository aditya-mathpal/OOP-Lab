import java.util.GregorianCalendar;

class Person {
    private String name;
    private GregorianCalendar dob;

    public Person(String name, GregorianCalendar dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getDob() {
        return dob;
    }
    public void setDob(GregorianCalendar dob) {
        this.dob = dob;
    }
}

class CollegeGraduate extends Person {
    private double GPA;
    private GregorianCalendar yearOfGraduation;

    public CollegeGraduate(String name, GregorianCalendar dob, double GPA, GregorianCalendar yearOfGraduation) {
        super(name,dob);
        this.GPA = GPA;
        this.yearOfGraduation = yearOfGraduation;
    }

    public double getGPA() {
        return GPA;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public GregorianCalendar getYearOfGraduation() {
        return yearOfGraduation;
    }
    public void setYearOfGraduation(GregorianCalendar yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }
    
    public void displayCollegeRecords() {
        System.out.println("Name: " + getName() + "\nDate of Birth: " + getDob().get(GregorianCalendar.DATE) + "-" + (getDob().get(GregorianCalendar.MONTH)+1) + "-" + getDob().get(GregorianCalendar.YEAR) + "\nGPA: " + getGPA() + "\nYear of Graduation: " + getYearOfGraduation().get(GregorianCalendar.YEAR));
    }
    
}

class CollegeRecords {
    public static void main(String[] args) {
        CollegeGraduate obj = new CollegeGraduate("John Doe", new GregorianCalendar(1995, 5, 15), 9.2, new GregorianCalendar(2017, 0, 1));
        obj.displayCollegeRecords();
    }
}

/*
output:
Name: John Doe
Date of Birth: 15-6-1995
GPA: 9.2
Year of Graduation: 2017
 */