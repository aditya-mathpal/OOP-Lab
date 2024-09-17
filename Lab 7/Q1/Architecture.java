import com.course.structure.Building;
import com.course.structure.House;
import com.course.structure.School;

public class Architecture {
    public static void main(String args[]) {
        new Building(2000, 10);
        new House(500, 10, 3, 3);
        new School(2000, 5, 150, "Elementary");
    }
}