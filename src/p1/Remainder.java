package p1;

public class Remainder {

    public static void main(String[] args) {
        int num = 10;
        System.out.println(remainder(num));
    }

    public static int remainder(int n) {
        int a = 2;
        while(a<(n/2)) {
            if(n%a==1) break;
            a++;
        }
        if(a==(n/2)) return n-1;
        return a;
    }
}
