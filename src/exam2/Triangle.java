package exam2;

public class Triangle {

    public static int[] dp = {};

    public static int point = 0;

    public static int max = 0;

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        dp = new int[triangle.length];

        search(triangle, 0, 0);

        System.out.println(max);
    }

    public static void search (int[][] triangle, int currentRow, int currentId) {
        if(point==0) dp[point] = triangle[currentRow][currentId];
        else dp[point] = dp[point-1] + triangle[currentRow][currentId];

        if(dp[point]>max) max = dp[point];

        point++;

        if(point<triangle.length) search(triangle, currentRow+1, currentId);
        if(point<triangle.length) search(triangle, currentRow+1, currentId+1);

        point--;
    }
}
