package exam2;

import java.util.*;

// 큐에서 하나의 노드를 꺼냄
// 해당 노드에 연결된 노드중 방문하지 않은 노드를 방문하고 차례대로 큐에 삽입
public class BreathSearch {
    public static int number = 7;
    public static boolean[] c = new boolean[8];
    public static Vector<Integer> a[];

    public static void main(String[] args) {
        init();
        bfs(1);
    }

    public static void init() {
        a = new Vector[number + 1];

        for(int i=0 ; i<=number ; ++i) {
            a[i] = new Vector<>();
        }

        a[1].add(2);
        a[2].add(1);

        a[1].add(3);
        a[3].add(1);

        a[2].add(3);
        a[3].add(2);

        a[2].add(4);
        a[4].add(2);

        a[2].add(5);
        a[5].add(2);

        a[3].add(6);
        a[6].add(7);

        a[3].add(7);
        a[7].add(3);

        for(Vector l : a) {
            System.out.println(l);
        }

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        c[start] = true;
        while(!queue.isEmpty()) {
            System.out.println(queue);
            int x = queue.poll();
            System.out.println("x : " + x);
            for(int i=0 ; i<a[x].size() ; i++) {
                int y = a[x].get(i);
                if(!c[y]) {
                    queue.offer(y);
                    c[y] = true;
                }
            }
        }
    }
}
