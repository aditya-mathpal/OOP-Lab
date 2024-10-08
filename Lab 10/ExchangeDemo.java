class Gen {
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class ExchangeDemo {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        System.out.println("Initial array: ");
        for(Integer i:arr) System.out.print(" " + i + " ");
        Gen.swap(arr,1,3);
        System.out.println("\nAfter swap: ");
        for(Integer i:arr) System.out.print(" " + i + " ");
    }
}

/*
output:
Initial array: 
 1  2  3  4  5
After swap:
 1  4  3  2  5
 */