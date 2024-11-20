package exam2;

public class DemiWork {

    public static void main(String[] args) {
        int n = 3;
        int[] works = {1, 1};

        printArray(works);

        heapSort(works);

        printArray(works);
        System.out.println(calc(n, works));
    }

    public static long calc(int n, int[] works) {
        long result = 0;

        int count = n;

        int flag;

        int scope = 0;

        while(true) {
            flag = 0;
            for(int i=0 ; i<=scope ; i++) {
                System.out.println("i : "  + i + ", l : " + works.length);
                if(works[i]==0) {
                    continue;
                }
                System.out.println("p : " + i);
                works[i]--;
                count--;
                flag = 1;
                System.out.println("count : " + count);
                printArray(works);
                if(count==0) break;
                if(scope<(works.length-1) && works[scope]<works[scope+1]) scope++;
            }
            if(flag==0 || count==0) break;
        }


        for(int i=0 ; i<works.length ; i++) {
            result += (works[i] * works[i]);
        }

        printArray(works);
        return result;
    }

    public static void heapSort(int[] arr) {
        int temp;

        for(int i=arr.length-1 ; i>0 ; i--) {
            heap(arr, i);
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }

    public static void heap(int[] arr, int n) {
        int search;
        int root;
        int temp;

        for(int i=n ; i>=0 ; i--) {
            search = i;
            while(search>0) {
                root = (search-1)/2;
                if(arr[root] > arr[search]) {
                    temp = arr[root];
                    arr[root] = arr[search];
                    arr[search] = temp;
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
