package p1;

public class Harshad {

    public static void main(String[] args) {
        int num = 13;
        System.out.println(solution(getDigitSum(num), num));
    }

    public static boolean solution(int hap, int n) {
        if(n%hap==0) return true; else return false;
    }

    public static int getDigitSum(int n) {
        int hap = 0;
        String[] split = String.valueOf(n).split("");
        for(int i=0 ; i<split.length ; i++) {
            System.out.println(split[i]);
            hap += Integer.parseInt(split[i]);
        }
        return hap;
    }
}
