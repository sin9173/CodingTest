package exam2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BreathSearch2 {

    public static int number = 7;

    public static Vector<Integer>[] arr = new Vector[number + 1];

    public static boolean[] check = new boolean[number + 1];

    public static ArrayList<Integer> result = new ArrayList<>();


    public static void main(String[] args) {
        init();
        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = true;

        while(!q.isEmpty()) {
            int x = q.poll();
            result.add(x);
            for(int i=0 ; i<arr[x].size() ; i++) {
                int y = arr[x].get(i);
                if(!check[y]) {
                    check[y] = true;
                    q.offer(y);
                }
            }
        }

        System.out.println("result : " + result);
    }

    public static void init() {
        for(int i=0 ; i<arr.length ; i++) {
            arr[i] = new Vector<>();
        }

        arr[1].add(2);
        arr[2].add(1);

        arr[1].add(3);
        arr[3].add(1);

        arr[2].add(3);
        arr[3].add(2);

        arr[2].add(4);
        arr[4].add(2);

        arr[2].add(5);
        arr[5].add(2);

        arr[3].add(6);
        arr[6].add(3);

        arr[7].add(3);
        arr[3].add(7);


        for(Vector v : arr) {
            System.out.println(v);
        }

        System.out.println("=====================");
    }
}
