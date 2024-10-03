package myPackages.p1;

public class Maximum {
    public static int max(int a, int b, int c) {
        return (a>b)?(a>c)?a:c:(b>c)?b:c;
    }
    public static double max(double a, double b, double c) {
        return (a>b)?(a>c)?a:c:(b>c)?b:c;
    }
    public static int max(int arr[]) {
        int len = arr.length, max=arr[0], i;
        for(i=1;i<len;i++)
            if(arr[i]>max) max = arr[i];
        return max;
    }
    public static int max(int arr[][]) {
        int len = arr.length, max = arr[0][0], i, j;
        for(i=0;i<len;i++) {
            int len2 = arr[i].length;
            for(j=0;j<len2;j++)
                if(arr[i][j]>max) max = arr[i][j];
        }
        return max;
    }
}
