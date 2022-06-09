package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sangsu {

    public static String s = "";
    public static String turn = "";
    public static int num1 = 0;
    public static int num2 = 0;

    public static String[] split = {};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine().replaceAll(" ", "~");
        for(int i=0 ; i<s.length() ; i++) turn = s.substring(i, i+1) + turn;

        split = turn.split("~");

        num1 = Integer.parseInt(split[0]);
        num2 = Integer.parseInt(split[1]);

        if(num1>num2) System.out.println(num1);
        else System.out.println(num2);
    }
}
