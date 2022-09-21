package p1;

public class RevertNumber {

    public static void main(String[] args) {
        long n = 12345;
        System.out.println(solution(n));
    }

    public static int[] solution(long n) {
        String[] split = String.valueOf(n).split("");
        int[] arr = new int[split.length];
        for(int i=0 ; i<split.length ; i++) {
            arr[i] = Integer.parseInt(split[split.length - (i+1)]);
        }
        return arr;
    }
}
