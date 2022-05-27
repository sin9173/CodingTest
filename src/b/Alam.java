package b;

import java.util.Scanner;

public class Alam {

    public static int a = 0;
    public static int b = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        calc(a, b, 45);
    }


    public static void calc(int a, int b, int m) {
        if(a==0) a = 24;
        int temp = (a * 100) + b;

        if(m>b) m += (((m - b)/60) + 1) * 40;

        temp = temp - m;

        if(temp>=2400) temp -= 2400;

        a = temp/100;
        b = temp - (a * 100);

        System.out.println(a);
        System.out.println(b);
    }
}
