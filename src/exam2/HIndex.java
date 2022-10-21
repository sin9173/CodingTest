package exam2;

public class HIndex {

    public static void main(String[] args) {
        int[] c = {4, 4, 4};
        heapSort(c);

        printArray(c);

        System.out.println(check(c));
    }

    public static int check(int[] c) {
        int max = 0;
        int j;
        for(int i=0 ; i<c.length ; i++) {
            if(c[i]<=(c.length - i) && c[i]>max) {
                max = c[i];
            }
            if(i==0) j=0;
            else j=c[i-1];

            for(; j<c[i] ; j++) {
                if(j<=(c.length-i) && j>max) {
                    max = j;
                }
            }
        }
        return max;
    }

    public static void heapSort(int[] c) {
        int temp;
        for(int i=c.length-1 ; i>0 ; i--) {
            heap(c, i);
            System.out.println("i : " + i);
            printArray(c);
            temp = c[0];
            c[0] = c[i];
            c[i] = temp;
            printArray(c);
        }
    }

    public static void heap(int[] c, int i) {
        int root;
        int temp;

        for( ; i>0 ; i--) {
            int search = i;
            while(search>0) {
                root = (search-1)/2;
                if(c[root]<c[search]) {
                    temp = c[root];
                    c[root] = c[search];
                    c[search] = temp;
                    System.out.println("root : " + root + ", search : " + search);
                    search = root;
                    printArray(c);
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
