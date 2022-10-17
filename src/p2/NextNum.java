package p2;

public class NextNum {

    public static void main(String[] args) {
        int n = 78;
        int binCount = binaryCount(n);
        int result = 0;
        for(int i=(n+1) ; i<=1000000 ; i++) {
            if(binCount==binaryCount(i)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    public static String binary(int n) {
        String bin = "";
        int remain;
        while(n>0) {
            remain = n%2;
            n = n/2;
            bin = remain + bin;
        }
        return bin;
    }

    public static int binaryCount(int n) {
        int count = 0;
        while(n>0) {
            count+=(n%2);
            n = n/2;
        }
        return count;
    }
}
