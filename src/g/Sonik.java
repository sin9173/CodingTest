package g;

import java.util.Scanner;

public class Sonik {

    public static long elem = 0;
    public static long cost = 0;
    public static long price = 0;

    public static long son = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elem = scanner.nextInt();
        cost = scanner.nextInt();
        price = scanner.nextInt();

        try {
            son = elem/(price-cost) + 1;
            System.out.println(son>0?son:-1);
        } catch (ArithmeticException e) {
            System.out.println(-1);
        }
    }
}
