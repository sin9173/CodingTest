package exam2;

public class TargetNumber {

    public static int count = 0;

    public static int[] dp;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        dp = new int[numbers.length];

        search(numbers, target, 0, 1);
        search(numbers, target, 0, -1);

        System.out.println("count : " + count);
    }

    public static void search(int[] numbers, int target, int i, int flag) {
        System.out.println("i : " + i + ", length : " + numbers.length);

        if(i==0) dp[i] = numbers[i] * flag;
        else dp[i] = dp[i-1] + (numbers[i] * flag);

        if(i==(numbers.length-1)) {
            if(dp[i]==target) count++;
            printArray(dp);
            return;
        }

        search(numbers, target, i+1, 1);
        search(numbers, target, i+1, -1);
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
