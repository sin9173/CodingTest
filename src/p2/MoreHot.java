package p2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MoreHot {
    public static int point;

    public static int[] mins = new int[2];

    public static PriorityQueue<Integer> queue;

    public static void main(String[] args) {
        int[] scoville = {1, 1};
        int k = 10;

        int count = 0;

        queue = new PriorityQueue<Integer>((i1, i2) -> i1.compareTo(i2));
        point = scoville.length - 1;

        for(int i=0 ; i<scoville.length ; i++) {
            queue.offer(scoville[i]);
        }

        System.out.println(queue);

        while(true) {
//            if(scoville[1]==-1 && scoville[0]<k) {
//                count = -1;
//                break;
//            };

            if(queue.size()==1 && queue.peek()<k) {
                count = -1;
                break;
            }
            if(mix(scoville, k)) break;
            count++;
        }

        System.out.println("count : " + count);
    }


    public static boolean mix(int[] arr, int k) {
        //heap(arr, point);
        //System.out.println("p : " + point + ", f : " + arr[0]);
        //if(arr[0]>=k) return true;
        //mins[0] = arr[0];
        mins[0] = queue.poll();
        if(mins[0]>=k) return true;

        System.out.println(queue);

        //arr[0] = arr[point];
        //arr[point] = -1;
        //point--;

        //printArray(arr);

        //heap(arr, point);
        //mins[1] = arr[0];
        //arr[0] = arr[point];
        //arr[point] = mins[0] + (mins[1] * 2);

        //printArray(arr);

        mins[1] = queue.poll();
        queue.offer(mins[0] + (mins[1] * 2));
        System.out.println(queue);

        return false;
    }

    public static void heap(int[] arr, int i) {
        int search;
        int root;
        int temp;
        for( ; i>=0 ; i--) {
            search = i;
            while(search>0) {
                root = (search-1)/2;
                if(arr[search]<arr[root]) {
                    temp = arr[search];
                    arr[search] = arr[root];
                    arr[root] = temp;
                    search = root;
                } else {
                    break;
                }
            }
        }
    }

    public static boolean check(int[] sc, int k) {
        for(int i=0 ; i<sc.length ; i++) {
            if(sc[i]==-1) return true;
            if(sc[i]<k) return false;
        }
        return true;
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
