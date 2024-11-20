package exam2;

public class MultiSet {

    public static int val = 0;
    public static int rem = 0;

    public static void main(String[] args) {
        int n = 4;
        int s = 3;

        val = s/n;
        rem = s%n;

        int[] arr = new int[n];

        for(int i=0 ; i<arr.length ; i++) {
            arr[i] = val;
        }

        for(int i=(arr.length-1) ; i>=(arr.length-rem) ; i--) {
            arr[i]+=1;
        }


        printArray(arr);
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
