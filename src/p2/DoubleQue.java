package p2;

public class DoubleQue {

    public static long sum_a = 0;
    public static long sum_b = 0;
    public static long sum_total = 0;
    public static long middle = 0;

    public static int[] array1 = null;
    public static int[] array2 = null;

    public static int a_st_point = 0;
    public static int a_ed_point = 0;

    public static int b_st_point = 0;
    public static int b_ed_point = 0;

    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        init(queue1, queue2);
        cycle(array1, array2);
    }


    public static long cycle(int[] a, int[] b) {
        int temp;
        int count = 0;
        int max_count = a.length;
        while(sum_a!=middle || sum_b!=middle) {
            while(sum_a>middle) {
                temp = a[a_st_point++];
                b[++b_ed_point] = temp;

                sum_a -= temp;
                sum_b += temp;
                count++;
                if(count>=max_count) return -1;
                printArray(a);
                printArray(b);
                System.out.println("count : " + count);
                System.out.println("sum_a : " + sum_a + ", sum_b : " + sum_b + ", middle : " + middle);
                System.out.println("========================");
            }

            while(sum_b>middle) {
                temp = b[b_st_point++];
                a[++a_ed_point] = temp;

                sum_b -= temp;
                sum_a += temp;
                count++;
                if(count>=max_count) return -1;
                printArray(a);
                printArray(b);
                System.out.println("count : " + count);
                System.out.println("sum_a : " + sum_a + ", sum_b : " + sum_b + ", middle : " + middle);
                System.out.println("========================");
            }
        }
        return count;
    }

    //초기화
    public static void init(int[] a, int[] b) {
        array1 = new int[(a.length + b.length) * 2];
        array2 = new int[(a.length + b.length) * 2];

        a_st_point = 0;
        a_ed_point = a.length -1;

        b_st_point = 0;
        b_ed_point = b.length -1;

        for(int i=0 ; i<a.length ; i++) {
            sum_a += a[i];
            array1[i] = a[i];
        }
        for(int i=0 ; i<b.length ; i++) {
            sum_b += b[i];
            array2[i] = b[i];
        }
        sum_total = sum_a + sum_b;
        middle = sum_total/2;
    }

    //큐입력
    public static int[] insert(int[] arr, int a) {
        int[] new_arr = new int[arr.length + 1];
        for(int i=0 ; i<arr.length ; i++ ) new_arr[i] = arr[i];
        new_arr[new_arr.length - 1] = a;
        return new_arr;
    }

    //큐출력
    public static int[] delete(int[] arr) {
        int[] new_arr = new int[arr.length - 1];
        for(int i=1 ; i<arr.length ; i++) new_arr[i-1] = arr[i];
        return new_arr;
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}
