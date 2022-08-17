package exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetChange {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        char[] arr = s.toCharArray();
        s = "";
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i]<96) s += (char)((int)arr[i] + 32);
            else s += (char)((int)arr[i] - 32);
        }
        return s;
    }
}
