package exam2;

//힙은 최소값이나 최대값을 빠르게 찾아내기 위해 완전 이진 트리를 기반으로 하는 트리
//최대힙과 최소힙이 존재
//최대힙은 부모노드가 자식노드보다 큰 힙
public class HeapSort {



    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        printArray(arr);
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        int temp;
        for(int i = (arr.length - 1) ; i>=0 ; i--) {
            heap(arr, i);
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
        printArray(arr);
    }

    public static void heap(int[] arr, int i) {
        int temp = 0;
        int search;
        int root = 0;
        for( ; i>0 ; i--) {
            search = i;
            while(search>0) {
                root = (search - 1) /2;
                System.out.println("under : " + arr[search] + ", upper : " + arr[root]);
                if(arr[search]>arr[root]) {
                    temp = arr[search];
                    arr[search] = arr[root];
                    arr[root] = temp;
                    printArray(arr);
                    search = root;
                } else {
                    break;
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
