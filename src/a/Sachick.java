package a;

import java.util.Scanner;

public class Sachick {
    public static int c = 0;
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        nam(a+b);
        nam((a%c) + (b%c));
        nam(a*b);
        nam((a%c) * (b%c));
    }
    public static void nam(int a) {
        System.out.println(a%c);
    }

}
