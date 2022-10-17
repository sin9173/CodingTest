package exam2;

public class UnionFind {

    public static void main(String[] args) {
        int[] parent = new int[11];
        for(int i=0 ; i<=10 ; i++) {
            parent[i] = i;
        }

        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent,6, 7);
        unionParent(parent, 7, 8);


        printArray(parent);

        System.out.println("1과 5 연결 : " + findParent(parent, 1, 3));
    }

    public static int getParent(int parent[], int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    //두 부모 노드를 합치는 함수 (적은쪽으로 합쳐짐)
    public static void unionParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    public static int findParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return 1;
        return 0;
    }


    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }


}
