package c;

import java.util.Scanner;

public class Gugudan {

    public static int a = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        for(int i=1 ; i<10 ; i++) System.out.println(a + " * " + i + " = " + (a * i));
    }
}
