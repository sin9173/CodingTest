package exam2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

// 노드 = 정점 = 도시 : 그래프에서 동그라미에 해당하는 부분
// 간선 = 거리 = 비용 : 그래프에서 선에 해당하는 부분
// 최소 간선 수 : 노드개수 - 1
// 거리가 짧은 순서대로 그래프에 포함 (간선정보를 오름차순으로 정렬 후  그래프에 포함)
// 사이클이 형성되는 간선은 제외 (Union Find 로 확인)
public class Kruskal {

    public static void main(String[] args) {
        int n = 7; //정점의 개수
        int m = 11; //간선의 개수

        Vector<Edge> v = new Vector<>();

        v.add(new Edge(1, 7, 12));
        v.add(new Edge(1, 4, 28));
        v.add(new Edge(1, 2, 67));
        v.add(new Edge(1, 5, 17));
        v.add(new Edge(2, 4, 24));
        v.add(new Edge(2, 5, 62));
        v.add(new Edge(3, 5, 20));
        v.add(new Edge(3, 6, 37));
        v.add(new Edge(4, 7, 13));
        v.add(new Edge(5, 6, 45));
        v.add(new Edge(5, 7, 73));

        System.out.println(v);

        //간선의 비용을 기준으로 오름차순 정렬
        Collections.sort(v);

        System.out.println(v);

        //각 정점이 포함된 그래프가 어디인지 저장
        int[] parent = new int[n];
        for(int i=0 ; i<n ; i++) {
            parent[i] = i;
        }

        int sum = 0;
        for(int i=0 ; i<v.size() ; i++) {
            //사이클이 발생하지 않는 경우 그래프에 포함
            if(findParent(parent, v.get(i).node[0] - 1, v.get(i).node[1] - 1)==0) {
                sum += v.get(i).distance;
                unionParent(parent, v.get(i).node[0] -1, v.get(i).node[1] - 1);
            }
        }

        System.out.println(sum);
    }

    public static int getParent(int[] parent, int x) {
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = parent[a];
        else parent[a] = parent[b];
    }

    public static int findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return 1;
        return 0;
    }
}

class Edge implements Comparable<Edge> {
    public int[] node = new int[2];
    public int distance;

    Edge(int a, int b, int distance) {
        this.node[0] = a;
        this.node[1] = b;
        this.distance = distance;
    }


    @Override
    public int compareTo(Edge o) {
        if(this.distance > o.distance) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node=" + Arrays.toString(node) +
                ", distance=" + distance +
                '}';
    }
}
