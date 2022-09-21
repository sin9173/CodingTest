package p1;

public class Aver {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        return aver(hap(arr), arr.length);
    }

    public static int hap(int[] arr) {
        int hap = 0;
        for(int i=0 ; i<arr.length ; i++) hap += arr[i];
        return hap;
    }

    public static double aver(double hap, double count) {
        return hap/count;
    }
}
