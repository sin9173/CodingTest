package c;

import java.util.Scanner;

public class PlusCycle {

    public static String n = "";

    public static int num = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.next();
        num = Integer.parseInt(n);
        if(n.length()==1) n = "0" + n;
        System.out.println(cycle(Integer.parseInt(n.substring(0, 1)), Integer.parseInt(n.substring(1, 2))));
    }

    public static int cycle(int a, int b) {
        int hap = a + b;
        String f = String.valueOf(b);
        f = f.substring(f.length() - 1);
        String r = String.valueOf(hap);
        r = r.substring(r.length() - 1);
        //System.out.println(f + " " + r);
        if(Integer.parseInt(f + r) == num) {
            return 1;
        } else {
            return cycle(Integer.parseInt(f), Integer.parseInt(r)) + 1;
        }
    }
}
