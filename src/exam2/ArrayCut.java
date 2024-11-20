package exam2;

import java.util.ArrayList;

public class ArrayCut {

    public static int[][] arr;
    public static int[] arrAll;

    public static void main(String[] args) {
        int n = 3;
        int left = 2;
        int right = 5;

        //init(n);

//        for(int i=0 ; i<arr.length ; i++) {
//            printArray(arr[i]);
//        }

        //serial(2, 5);

        serial2(n, left, right);

        printArray(arrAll);
    }

    public static void serial(long left, long right) {
        //arrAll = new int[(right-left) + 1];
        ArrayList<Integer> list = new ArrayList<>();
        long p = 0;

        for(int i=0 ; i<arr.length ; i++) {
            for(int j=0 ; j<arr[i].length ; j++) {
                System.out.println("p : " + p);
                //if(p>=left) arrAll[p-left] = arr[i][j];
                if(p>=left) list.add(arr[i][j]);
                p++;
                if(p>right) break;
            }
            if(p>right) break;
        }

        arrAll = new int[list.size()];

        for(int i=0 ; i<list.size() ; i++) {
            arrAll[i] = list.get(i);
        }
    }

    public static void serial2(int n, long left, long right) {
        long y;
        long x;

        long p = n * (left/n);

        ArrayList<Integer> list = new ArrayList<>();

        for(long i=(left/n) ; i<n ; i++) {
            y = i+1;
            for(int j=0 ; j<n ; j++) {
                x = j+1;
                if(y>=x) x = y;
                if(p>=left) list.add((int) x);
                p++;
                if(p>right) break;
            }
            if(p>right) break;
        }

        arrAll = new int[list.size()];

        for(int i=0 ; i<list.size() ; i++) {
            arrAll[i] = list.get(i);
        }
    }

    public static void init(int n) {
        arr = new int[n][n];

        int y;
        int x;

        for(int i=0 ; i<arr.length ; i++) {
            y = i+1;
            for(int j=0 ; j<arr[i].length ; j++) {
                x = j+1;
                if(y>=x) {
                    arr[i][j] = y;
                } else {
                    arr[i][j] = x;
                }
            }
        }
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) if(arr[i]!=0) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
