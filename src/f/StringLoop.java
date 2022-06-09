package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.Collectors;

public class StringLoop {

    public static int test_case = 0;
    public static int count = 0;

    public static String s = "";
    public static String p = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        test_case = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<test_case ; i++) {
            String str = bf.readLine().replaceAll(" ", "~");
            String[] split = str.split("~");
            System.out.println(test(Integer.parseInt(split[0]), split[1]));
        }
    }

    public static String test(int count, String s) {
        String result = "";
        for(int i=0 ; i<s.length() ; i++) {
            result += Collections.nCopies(count, s.substring(i, i+1)).stream()
                    .collect(Collectors.joining(""));
        }
        return result;
    }
}
