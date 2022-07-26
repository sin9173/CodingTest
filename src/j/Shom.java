package j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shom {

    public static int input = 0;

    public static int count = 1;

    public static int result = 666;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(bf.readLine());

        for(int i=667 ; input!=1 ; i++) {
            if(check(i)) {
                count++;
                System.out.println("count : " + count + ", result : " + result);
            }
            if(count==input) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    public static boolean check(int num) {
        String s = String.valueOf(num);
        if(s.contains("666")) return true;
        else return false;
    }
}
