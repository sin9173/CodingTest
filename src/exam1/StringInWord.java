package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringInWord {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String[] split = s.split(" ");
        int max = 0;
        String answer = split[0];
        for(int i=0 ; i<split.length ; i++) {
            if(split[i].length()>max) {
                max = split[i].length();
                answer = split[i];
            }
        }
        return answer;
    }
}
