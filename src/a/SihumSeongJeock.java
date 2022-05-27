package a;

import java.util.HashMap;
import java.util.Scanner;

public class SihumSeongJeock {

    public static int a = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";

        HashMap<Integer, String> map = new HashMap<Integer, String>() {{
            put(10, "A");
            put(9, "A");
            put(8, "B");
            put(7, "C");
            put(6, "D");
        }};


        a = scanner.nextInt();

        result = map.get(a/10);
        System.out.println(result!=null?result:"F");

    }
}
