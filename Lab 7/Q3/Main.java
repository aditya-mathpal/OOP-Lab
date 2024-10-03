

interface Series {
    int getNext();
    void reset();
    void setStart(int num);
}

class ByTwos implements Series {
    private int start;
    private int val;
    public int getNext() {
        val += 2;
        return val;
    }
    public void reset() {
        val = start;
    }
    public void setStart(int num) {
        val = num;
        start = num;
    }
}

public class Main {
    public static void main(String args[]) {
        ByTwos ob = new ByTwos();
        ob.setStart(1);
        for(int i=0;i<2;i++)
            System.out.println("Next number: " + ob.getNext());
        ob.reset();
        System.out.println("Next number: " + ob.getNext());
    }
}

/*
output:
Next number: 3
Next number: 5
Next number: 3
 */