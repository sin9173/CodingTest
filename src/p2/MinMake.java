package p2;

import java.util.Arrays;

public class MinMake {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4};

        Arrays.sort(a);//quickSort(a, 0, a.length-1, 0);
        Arrays.sort(b); //quickSort(b, 0, b.length-1, 1);


        System.out.println("a : ");
        printArray(a);
        System.out.println("b : ");
        printArray(b);

        System.out.println("result : " + cycle(a, b));
    }

    public static int cycle(int[] a, int[] b) {
        int sum = 0;
        for(int i=0 ; i<a.length ; i++) {
            sum += a[i] * b[a.length - (i+1)];
        }
        return sum;
    }

    public static int[] quickSort(int[] arr, int originLeft, int originRight, int flag) {
        int left = originLeft;
        int right = originRight;
        int pivot = arr[(originLeft + originRight)/2];

        int check = 0;

        for(int i=1 ; i<arr.length ; i++) {
            if(arr[i]<=arr[i-1] && flag==0) check++;
            if(arr[i]>=arr[i-1] && flag==1) check++;
        }
        if(check==0) return arr;

        while(left<=right) {
            if(flag==0) {
                while(arr[left]<pivot) left++;
                while(arr[right]>pivot) right--;
            } else {
                while(arr[left]>pivot) left++;
                while(arr[right]<pivot) right--;
            }

            if(left<=right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
                printArray(arr);
            }

            if(right>originLeft) quickSort(arr, originLeft, right, flag);
            if(left<originRight) quickSort(arr, left, originRight, flag);
        }
        return arr;
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
