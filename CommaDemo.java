//Q6

import java.util.Scanner;

class Comma {
    String inputString;
    String fixString() {
        int len = this.inputString.length(), count = 0;
        String result = "";
        for(int i=len-1;i>=0;i--) {
            if(count%3==0 && count!=0) result = "," + result;
            result = this.inputString.charAt(i) + result;
            count++;
        }
        return result;
    }
}

public class CommaDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Comma num = new Comma();
        System.out.print("Input String: ");
        num.inputString = sc.nextLine();
        System.out.println("Output String: " + num.fixString());
    }
}

/*
output:
Input String: 123456
Output String: 123,456
 */