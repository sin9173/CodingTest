package exam2;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraHeap {

    public static int number = 6;
    public static int INF = Integer.MAX_VALUE;

    public static ArrayList<ArrayList<Node>> a = new ArrayList<>();

    public static int[] d = new int[number + 1];

    public static void main(String[] args) {
        init();
        System.out.println(a);
        dijkstra(1);
        printArray(d);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost, o2.cost)));
        q.offer(new Node(start, 0));
        d[start] = 0;

        while(!q.isEmpty()) {
            Node currentNode = q.poll();
            int current = currentNode.idx;
            int distance = currentNode.cost;

            System.out.println("current : " + current + ", distance : " + distance);

            //최단 거리가 아닌 경우 스킵
            if(d[current] < distance) continue;
            for(int i=0 ; i<a.get(current).size() ; i++) {
                //선택된 노드의 인접노드
                int next = a.get(current).get(i).idx;

                //선택된 노드를 거쳐서 인접노드로 가는 비용
                int nextDistance = distance + a.get(current).get(i).cost;

                if(nextDistance < d[next]) {
                    d[next] = nextDistance;
                    q.offer(new Node(next, nextDistance));
                }
            }
       }

    }

    public static void init() {
        for (int i=0 ; i<=number ; i++) {
            a.add(new ArrayList<Node>());
        }

        for(int i=0 ; i<=number ; i++) {
            d[i] = INF;
        }

        a.get(1).add(new Node(2, 2));
        a.get(1).add(new Node(3, 5));
        a.get(1).add(new Node(4, 1));

        a.get(2).add(new Node(1, 2));
        a.get(2).add(new Node(3, 3));
        a.get(2).add(new Node(4, 2));

        a.get(3).add(new Node(1, 5));
        a.get(3).add(new Node(2, 3));
        a.get(3).add(new Node(4, 5));
        a.get(3).add(new Node(5, 1));
        a.get(3).add(new Node(6, 5));

        a.get(4).add(new Node(1, 1));
        a.get(4).add(new Node(2, 2));
        a.get(4).add(new Node(3, 3));
        a.get(4).add(new Node(5, 1));

        a.get(5).add(new Node(3, 1));
        a.get(5).add(new Node(4, 1));
        a.get(5).add(new Node(6, 2));

        a.get(6).add(new Node(3, 5));
        a.get(6).add(new Node(5, 2));
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }

}


class Node {
    int idx, cost;

    Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "idx=" + idx +
                ", cost=" + cost +
                '}';
    }
}

