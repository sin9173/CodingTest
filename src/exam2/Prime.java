package exam2;

public class Prime {

    public static int[] arr = null;

    public static void main(String[] args) {
        int num = 1000;
        init(num);
        printArray(arr);
        check(num);
        printArray(arr);
    }

    public static void init(int num) {
        arr = new int[num + 1];
        for(int i=2 ; i<arr.length ; i++) {
            arr[i] = i;
        }
    }

    public static void check(int num) {
        for(int i=2 ; i<=num ; i++) {
            if(arr[i]==0) continue;
            for(int j=i ; j<=num ; j+=i) {
                if(j==i) continue;
                if(arr[j]==0) continue;
                arr[j] = 0;
            }
        }
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) if(arr[i]!=0) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
