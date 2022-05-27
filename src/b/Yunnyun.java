package b;

import java.util.Scanner;

public class Yunnyun {

    public static int a = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;

        a = scanner.nextInt();

        result += a%4==0?1:0;

        result += a%100!=0?1:0;

        result += a%400==0?1:0;

        System.out.println(result/2);
    }
}
