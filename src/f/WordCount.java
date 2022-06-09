package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCount {
    public static String s = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine().trim();
        if(s.equals("")) System.out.println(0);
        else System.out.println(s.replaceAll(" ", "~").split("~").length);
    }
}
