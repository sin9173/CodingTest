package a;

import java.util.Scanner;

public class Bigyo {

    public static String l = "<";
    public static String r = ">";
    public static String e = "==";

    public static int a = 0;
    public static int b = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        bigyo();

    }

    public static void bigyo() {
        if(a>b) {
            System.out.println(r);
        } else if(a<b) {
            System.out.println(l);
        } else {
            System.out.println(e);
        }
    }
}
