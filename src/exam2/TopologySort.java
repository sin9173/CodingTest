package exam2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//진입차수가 0인 정점을 큐에 삽입
//큐에서 원소를 꺼내 모든 간선을 제거
//간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입
//큐가 빌 때까지 반복 (모든 원소를 방문하기 전에 큐가 빈다면 싸이클이 존재하는것 )
// 큐에서 꺼낸 순서가 위상정렬의 결과
public class TopologySort {

    public static int MAX = 10;

    public static int n;
    public static int[] inDegree = new int[MAX];
    public static ArrayList<ArrayList<Integer>> a = new ArrayList<>();

    public static int[] result;

    public static void main(String[] args) {
        n = 7;
        init();
        topologySort();
        printArray(result);
    }

    public static void init() {
        for(int i=0 ; i<=n ; i++) {
            a.add(new ArrayList<>());
        }

        a.get(1).add(2);
        inDegree[2]++;
        a.get(1).add(5);
        inDegree[5]++;

        a.get(2).add(3);
        inDegree[3]++;

        a.get(3).add(4);
        inDegree[4]++;

        a.get(4).add(6);
        inDegree[6]++;

        a.get(5).add(6);
        inDegree[6]++;

        a.get(6).add(7);
        inDegree[7]++;
    }

    public static void topologySort() {
        result = new int[MAX];

        Queue<Integer> q = new LinkedList<>();

        //진입차수가 0인 노드를 큐에 삽입
        for(int i=1 ; i<=n ; i++) {
            if(inDegree[i] == 0) q.offer(i);
        }

        // 위상 정렬이 완전히 수행되려면 정확히 N개의 노드를 방문
        for(int i=1 ; i<=n ; i++) {
            // n개를 방문하기 전에 큐가 빈다면 사이클이 발생한 것
            if(q.isEmpty()) {
                System.out.println("사이클이 발생했습니다.");
                return;
            }
            int x = q.poll();
            result[i] = x;
            for(int j = 0 ; j<a.get(x).size() ; j++) {
                System.out.println("x : " + x);
                int y = a.get(x).get(j);
                //새롭게 진입차수가 0이 된 정점을 큐에 삽입
                if(--inDegree[y] == 0) {
                    q.offer(y);
                }
            }
        }
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
