package c;

import java.util.ArrayList;
import java.util.Scanner;

public class APlusB {

    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        testcase(count, scanner).stream().forEach(i -> System.out.println(i));
    }

    public static ArrayList<Integer> testcase(int count, Scanner scanner) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int a = 0;
        int b = 0;

        for(int i=0 ; i<count ; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            result.add(a + b);
        }
        return result;
    }
}
