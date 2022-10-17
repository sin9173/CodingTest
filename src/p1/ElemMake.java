package p1;

public class ElemMake {

    public static int result = 0;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(elemCheck(10));
        search(nums);
        System.out.println(result);
    }

    public static int solution(int[] nums) {
        return 0;
    }

    public static void search(int[] nums) {
        for(int i=0 ; i<nums.length-2 ; i++) {
            for(int j=i+1 ; j< nums.length-1 ; j++) {
                for(int k=j+1 ; k<nums.length ; k++) {
                    System.out.println("i : " + i + ", j : " + j + ", k : " + k);
                    if(elemCheck(nums[i] + nums[j] + nums[k])) result++;
                }
            }
        }
    }

    public static boolean elemCheck(int num) {
        for(int i=2 ; i<=num/2 ; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
