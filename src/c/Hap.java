package c;

import java.util.Scanner;

public class Hap {

    public static double a = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();

        System.out.println(Math.round((1 + a) * (a/2)));
    }
}
