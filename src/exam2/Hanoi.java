package exam2;

import java.util.ArrayList;

public class Hanoi {

    public static ArrayList<Integer[]> list = new ArrayList<Integer[]>();

    public static void main(String[] args) {
        int num = 2;

        hanoi(num, 1, 2, 3);

        list.stream().forEach(a -> printArray(a));
    }

    public static void hanoi(int n, int a, int b, int c) {
        if(n==1) {
            list.add(new Integer[] {a, c});
            return;
        }

        hanoi(n-1, a, c, b);

        list.add(new Integer[] {a, c});

        hanoi(n-1, b, a, c);
    }


    //배열출력
    public static void printArray(Integer[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
