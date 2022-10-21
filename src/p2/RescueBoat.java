package p2;

import java.util.ArrayList;

public class RescueBoat {

    public static int count = 0;
    public static int rescue = 0;

    public static int start_point = 0;

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        quickSort(people, 0, people.length-1);

        printArray(people);
        while(rescue<people.length) {
            count++;
            greed(people, limit);
        }

        System.out.println(count);
    }

    public static void quickSort(int[] arr, int originLeft, int originRight) {
        int left = originLeft;
        int right = originRight;
        int temp = 0;

        int pivot = arr[(originLeft + originRight)/2];

        while(left<=right) {
            while(arr[left]>pivot) left++;
            while(arr[right]<pivot) right--;

            if(left<=right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            printArray(arr);

            if(left<originRight) quickSort(arr, left, originRight);
            if(right>originLeft) quickSort(arr, originLeft, right);
        }
    }


    public static void greed(int[] p, int limit) {
        int sum = 0;

        ArrayList list = new ArrayList();

        while(true) {
            int flag = 0;
            for(int i=start_point ; i<p.length ; i++) {
                if(p[i]==255) continue;
                if(limit>=(sum + p[i])) {
                    if(i==start_point) start_point++;
                    flag = 1;
                    sum += p[i];
                    rescue++;
                    list.add(p[i]);
                    p[i] = 255;
                }
            }
            if(flag==0) break;
        }
        System.out.println(list);
    }


    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
