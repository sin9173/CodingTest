package b;

import java.util.Scanner;

public class Oven {
    public static String s1 = "";
    public static String s2 = "";

    public static int a = 0;
    public static int b = 0;
    public static int m = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        s1 = scanner.next();
        s2 = scanner.next();

        m = scanner.nextInt();

        a = Integer.parseInt(s1);
        b = Integer.parseInt(s2);

        calc(a, b, m);
    }

    public static void calc(int a, int b, int m) {
        if(a==0) a = 24;
        int temp = a * 100;
        m = m + b;
        if(m>=60) m += (m/60) * 40;
        temp += m;

        if(temp>=2400) temp -= 2400;

        a = temp/100;
        b = temp - (a * 100);

        System.out.println(a + " " + b);
    }


}
