package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        for(int i=0 ; i<s.length() ; i++) {
            String word1 = s.substring(i, i+1).toLowerCase();
            String word2 = s.substring(s.length()-(i+1), s.length()-i).toLowerCase();
            if(!word1.equals(word2)) return "NO";
        }
        return "YES";
    }
}
