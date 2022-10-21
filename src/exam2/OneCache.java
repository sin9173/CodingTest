package exam2;

import java.util.LinkedList;
import java.util.Queue;

public class OneCache {

    public static Queue<Integer> q = new LinkedList<>();
    public static String[] c;

    public static void main(String[] args) {
        int size = 3;
        String[] citi =  {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        c = new String[size];
        System.out.println(search(citi, size));
    }


    public static int search(String[] citi, int size) {
        int time = 0;
        int flag;

        if(size==0) return citi.length * 5;

        for(int i=0 ; i<citi.length ; i++) {
            citi[i] = citi[i].toUpperCase();
            flag = 0;
            for(int j=0 ; j<c.length ; j++) {
                if(c[j]==null) break;
                if(c[j].equals(citi[i])) {
                    flag=1;
                    time++;
                    int index = j;
                    q.removeIf(v -> v==index);
                    q.offer(j);
                    break;
                }
            }

            if(flag==0) {
                time+=5;
                int index;
                if(q.size()==size) {
                     index = q.poll();
                } else {
                    index = q.size();
                }
                q.offer(index);
                c[index] = citi[i];
            }
            System.out.println(q);
            printArray(c);
        }
        return time;
    }

    //배열출력
    public static void printArray(String[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }


}
