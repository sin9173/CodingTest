package exam2;

public class Dijkstra {
    public static int number = 6;

    public static int INF = 1000000000;

    // 전체 그래프를 초기화
    public static Integer[][] a = {
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0}
    };

    public static boolean[] v = new boolean[6]; //방문한 노드
    public static int[] d = new int[6]; //최단 거리

    // 가장 최소 거리를 가지는 정보를 반환
    public static int getSmallIndex() {
        int min = 1000000000;
        int index = 0;
        for(int i= 0 ; i<number ; i++) {
            if(d[i] < min && !v[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    //다익스트라 수행
    public static void dijkstra(int start) {
        for(int i=0 ; i<number ; i++) {
            d[i] = a[start][i];
        }
        //방문처리
        v[start] = true;
        for(int i=0 ; i<number-2 ; i++) {
            int current = getSmallIndex();
            v[current] = true;
            System.out.println("현재 : " + current);

            for(int j=0 ; j<6 ; j++) {
                if(!v[j]) {
                    if(d[current] + a[current][j] < d[j]) {
                        d[j] = d[current] + a[current][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        dijkstra(0);
        printArray(d);
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
