package exam2;

public class JumpWarp {

    public static int ans = 0;

    public static void main(String[] args) {
        int n = 5;

        System.out.println(jump(n));

    }

    public static int jump(int n) {
        System.out.println("n : " + n + ", ans : " + ans);
        if(n%2==1) {
            n--;
            ans++;
        }
        if(n<2) return ans + n;
        n /= 2;
        return jump(n);
    }
}
