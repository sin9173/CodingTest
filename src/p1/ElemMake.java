package p1;

public class ElemMake {

    public static void main(String[] args) {
        System.out.println(elemCheck(10));
    }

    public static int solution(int[] nums) {
        return 0;
    }

    public static int search(int[] nums, int count, int hap) {
//        for()
        return 0;
    }

    public static boolean elemCheck(int num) {
        for(int i=2 ; i<=num/2 ; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
