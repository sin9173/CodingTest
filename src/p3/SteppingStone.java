package p3;

public class SteppingStone {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5};
        int k = 3;
        int result = step(stones, k);

        System.out.println("친구들 : " + result);
    }


    public static int step(int[] stones, int k) {
        int min = 0;
        int max_pass = 0;

        while(max_pass<k) {
            int pass_count = 0;
            min = 200000001;
            for(int i=0 ; i<stones.length ; i++) {
                if(stones[i]==0) continue;
                if(stones[i]<min) {
                    min = stones[i];
                }
            }

            for(int i=0 ; i<stones.length ; i++) {
                if(stones[i]==min) stones[i] = 0;
                if(stones[i]<=min) pass_count++;
                else {
                    if(max_pass<pass_count) max_pass = pass_count;
                    pass_count = 0;
                }
            }
            printArray(stones);
            System.out.println("min : " + min);
            System.out.println("max_pass : " + max_pass);
        }

        return min;
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
