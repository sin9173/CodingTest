package h;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SosuHap {

    public static int hap = 0;
    public static int front = 0;
    public static int rear = 0;

    public static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        front = Integer.parseInt(bf.readLine());
        rear = Integer.parseInt(bf.readLine());

        for(int i=front ; i<=rear ; i++) if(check(i)) {
            hap+=i;
            if(min==0) min=i;
        }

        System.out.println(hap==0?-1:hap);
        if(hap!=0) System.out.println(min);
    }

    public static boolean check(int num) {
        if(num==1) return false;
        int a = num/2;
        while(a>1) {
            if(num%a==0) return false;
            else a--;
        }
        return true;
    }
}
