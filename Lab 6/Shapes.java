abstract class Figure {
    private int length, width;

    abstract double Area();

    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
}

class Rectangle extends Figure {
    Rectangle(int l, int b) {
        setLength(l);
        setWidth(b);
    }
    double Area() {
        return getLength()*getWidth();
    }
}

class Square extends Figure {
    Square(int l) {
        setLength(l);
    }
    double Area() {
        return getLength()*getLength();
    }
}

class Triangle extends Figure {
    Triangle(int l, int h) {
        setLength(l);
        setWidth(h);
    }
    double Area() {
        return 0.5*getLength()*getWidth();
    }
}

public class Shapes {
    public static void main(String args[]) {
        Figure r = new Rectangle(2, 5);
        Figure s = new Square(6);
        Figure t = new Triangle(4, 8);

        System.out.println("Area of the rectangle is " + r.Area());
        System.out.println("Area of the square is " + s.Area());
        System.out.println("Area of the triangle is " + t.Area());
    }
}

/*
output:
Area of the rectangle is 10.0
Area of the square is 36.0
Area of the triangle is 16.0
 */
