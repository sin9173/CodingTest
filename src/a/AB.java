package a;

import java.util.Scanner;

public class AB {

    public static void main(String[] args) {

        double a = 0;
        double b = 0;

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
        
        int aa = (int)a;
        int bb = (int)b;

        System.out.println(aa + bb);
        System.out.println(aa - bb);
        System.out.println(aa * bb);
        System.out.println(a / b);
        System.out.println(aa % bb);
    }
}
