package p2;

public class NumExpression {

    public static void main(String[] args) {
        int n = 15;
        int count = 1;
        for(int i=1 ; i<=(n/2) ; i++) {
            if(check(i, n)) count++;
        }

        System.out.println("count : " + count);

    }

    public static boolean check(int s, int n) {
        int hap = 0;
        boolean result = true;
        while(true) {
            System.out.print(s + ", ");
            hap += s;
            s++;
            if(hap==n) {
                result = true;
                break;
            }
            if(hap>n) {
                result = false;
                break;
            }
        }

        System.out.println("");
        return result;
    }
}
