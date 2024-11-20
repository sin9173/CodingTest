package exam2;

import java.util.HashSet;

public class Network {

    public static int[] index_arr;

    public static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int n = 2;
        //int[][] computers = {{1, 0, 0}, {0, 1, 0}, {1, 0, 1}};
        int[][] computers = {{1, 0}, {1, 1}};

        init(n);

        connection(computers);

//        printArray(index_arr);
//
//        union(3, 7);
//        printArray(index_arr);
//        union(2, 5);
//        printArray(index_arr);
//        union(5, 4);
//
//        printArray(index_arr);

        System.out.println(con_count());
    }

    public static int con_count() {
        int count = 0;
        int n = index_arr.length-1;

//        while(n>=0) {
//            n = getParent(n)-1;
//            count++;
//        }

        for(int i=0 ; i<index_arr.length ; i++) {
            set.add(index_arr[i]);
        }

        count = set.size();
        return count;
    }

    public static void connection(int[][] com) {
        int line;
        for(int i=1 ; i<com.length ; i++) {
            for(int j=(i-1) ; j>=0 ; j--) {
                line = com[i][j];
                if(line==1) {
                    if(com[j][i]==1) union(j, i);
                }
            }
        }
        printArray(index_arr);
    }

    public static void union(int a, int b) {
        int ap = getParent(a);
        int bp = getParent(b);

        System.out.println("a : " + ap + ", b : " + bp);

        if(ap<bp) {
            index_arr[b] = ap;
            index_arr[a] = ap;
        } else {
            index_arr[b] = bp;
            index_arr[a] = bp;
        }
    }

    public static int getParent(int n) {
        if(n == index_arr[n]) return n;
        return getParent(index_arr[n]);
    }

    public static void init(int n) {
        index_arr = new int[n];

        for(int i=0 ; i<index_arr.length ; i++) {
            index_arr[i] = i;
        }
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
