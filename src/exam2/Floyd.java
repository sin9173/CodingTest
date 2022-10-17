package exam2;

//모든 정점에서 모든 정점으로의 최단 경로
//거쳐가는 정점을 기준으로 알고리즘을 수행
public class Floyd {

    public static int INF = 1000000000;
    public static int[][] a = {
            {0 ,5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
    };

    public static void main(String[] args) {
        floydWarshall();
    }

    public static void floydWarshall() {
        int number = 4;

        //결과 그래프를 초기화
        int[][] d = new int[number][number];
        for(int i=0 ; i<number ; i++) {
            for(int j=0 ; j<number ; j++) {
                d[i][j] = a[i][j];
            }
        }

        // k = 거쳐가는 노드
        for(int k = 0 ; k <number ; k++) {
            //i = 출발노드
            for(int i=0 ; i<number ; i++) {
                //j = 도착 노드
                for(int j = 0 ; j < number ; j++) {
                    if(d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        //결과 출력
        for(int i=0 ; i<number ; i++) {
            System.out.print("[");
            for(int j =0 ; j<number ; j++) {
                System.out.print(d[i][j] + ", ");
            }
            System.out.println("]");
        }
    }
}
