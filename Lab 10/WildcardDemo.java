import java.util.ArrayList;

public class WildcardDemo {
    public static void display(ArrayList<?> list) {
        for (Object ele:list) System.out.print(" " + ele + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> intArr = new ArrayList<>();
        intArr.add(1);
        intArr.add(2);
        intArr.add(3);

        ArrayList<String> strArr = new ArrayList<>();
        strArr.add("Aditya");
        strArr.add("Pankaj");
        strArr.add("Mathpal");

        display(intArr);
        display(strArr);
    }
}

/*
output:
 1  2  3 
 Aditya  Pankaj  Mathpal
*/