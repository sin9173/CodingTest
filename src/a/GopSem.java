package a;


import java.util.Scanner;

public class GopSem {

    public static int a = 0;
    public static int b = 0;
    public static int dec = 10;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        int result = 0;

        result += gob();
        result += gob();
        result += gob();

        System.out.println(result);

    }

    public static int gob() {
        int nam = (b%dec);
        int g = a * nam;
        System.out.println(g/(dec/10));
        b = b - nam;
        dec *= 10;
        return g;
    }
}
