import com.course.structure.*;

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