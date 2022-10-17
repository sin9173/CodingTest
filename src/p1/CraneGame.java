package p1;

public class CraneGame {

    public static int[] basket = null;

    public static int stack_point = 0;

    public static int result = 0;

    public static void main(String[] args) {
        int[] moves = {1,5,3,5,1,2,1,4};
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        basket = new int[moves.length];
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        for(int i=0 ; i<moves.length ; i++) {
            int pickup = pickup(board, 0, moves[i]-1);
            if(pickup!=0) stackIn(pickup);
            basket_check();
        }
        int answer = result;
        return answer;
    }

    public static void stackIn(int a) {
        basket[stack_point] = a;
        stack_point++;
        for(int i : basket) System.out.print(i + ", ");
        System.out.println("");
        System.out.println("stack point : " +stack_point);
    }

    public static int stackOut() {
        stack_point--;
        int result = basket[stack_point];
        basket[stack_point] = 0;
        for(int i : basket) System.out.print(i + ", ");
        System.out.println("");
        System.out.println("stack point : " +stack_point);
        return result;
    }

    public static int pickup(int[][] arr, int i, int p) {
        if(i==arr.length) return 0;
        System.out.println("i : " + i + ", p : " + p + ", val : " + arr[i][p]);
        if(arr[i][p]!=0) {
            int result = arr[i][p];
            arr[i][p] = 0;
            return result;
        };
        return pickup(arr, i+1, p);
    }

    public static void basket_check() {
        if(basket[1]==0) return;
        if(basket[stack_point-1]==basket[stack_point-2]) {
            stackOut();
            stackOut();
            result+=2;
        }
    }

}
