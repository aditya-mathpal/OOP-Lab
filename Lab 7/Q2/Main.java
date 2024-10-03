import myPackages.p1.*;

public class Main {
    public static void main(String[] args) {
        int arr[] = {7,9,8}, mat[][] = {{6, 4, 8},{3, 0, 1}, {5, 9, 2}};
        System.out.println(Maximum.max(2,3,1) + " " + Maximum.max(5.0,6.0,4.0) + " " + Maximum.max(arr) + " " + Maximum.max(mat));
    }
}

/*
output:
3 6.0 9 9
 */