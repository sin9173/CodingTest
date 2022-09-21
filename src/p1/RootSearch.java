package p1;

public class RootSearch {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(solution(root(num)));
    }

    public static int solution(int r) {
        if(r==-1) {
            return -1;
        } else {
            r++;
            return r * r;
        }
    }

    public static int root(int n) {
        int r = 1;
        while((r*r)<n) {
            r++;
        }
        if((r*r)>n) r = -1;
        return r;
    }
}
