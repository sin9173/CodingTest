package p1;

import java.util.Arrays;

public class Sort1 {

    public static void main(String[] args) {
        long[] arr = {3, 8 ,2 ,5, 1, 9, 6};
        System.out.println(arrPrint(quickSort(arr, 0, arr.length-1)));
    }

    public static long[] quickSort(long[] arr, int originLeft, int originRight) {
        long pivot = arr[originLeft + ((originRight - originLeft)/2)];
        int left = originLeft;
        int right = originRight;

        while(left<=right) {
            while(arr[left]>pivot) left++;
            while(arr[right]<pivot) right--;
            if(left<=right) {
                long temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        if(right>originLeft) arr = quickSort(arr, originLeft, right);
        if(left<originRight) arr = quickSort(arr, left, originRight);

        return arr;
    }

    public static boolean arrPrint(long[] arr) {
        System.out.print("[");
        Arrays.stream(arr).forEach(a -> System.out.print(a + ", "));
        System.out.println("]");
        return false;
    }
}
