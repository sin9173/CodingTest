package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindString {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String f = bf.readLine();
        System.out.println(solution(s, f));
    }

    public static int solution(String s, String f) {
        int answer = 0;
        s = s.toUpperCase();
        f = f.toUpperCase();
        for(int i=0 ; i<s.length() ; i++) {
            if(s.substring(i, i+1).equals(f)) answer++;
        }
        return answer;
    }
}
