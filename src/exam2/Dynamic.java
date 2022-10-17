package exam2;

//하나의 문제를 단 한번만 풀도록 하는 알고리즘
//DP 의 가정
// 1. 큰 문제를 작은 문제로 나눌 수 있다.
// 2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.
public class Dynamic {
    public static long[] mem = new long[200]; //memoization : 결과를 저장해둠

    public static void main(String[] args) {
        System.out.println(dp(100));
    }

    public static long dp(int x) {
        if(x == 1) return 1;
        if(x == 2) return 1;
        if(mem[x] != 0) return mem[x];
        return mem[x] = dp(x - 1) + dp(x - 2);
    }
}
