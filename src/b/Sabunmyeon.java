package b;

import java.util.HashMap;
import java.util.Scanner;

public class Sabunmyeon {

    public static int a = 0;
    public static int b = 0;

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>() {{
            put("00", 3);
            put("01", 2);
            put("10", 4);
            put("11", 1);
        }};

        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.println(map.get(calc()));
    }

    public static String calc() {
        String q1 = a>=1 ? "1" : "0";
        String q2 = b>=1 ? "1" : "0";

        return q1 + q2;
    }
}
