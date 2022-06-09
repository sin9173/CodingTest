package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascii {

    public static char s = '0';
    public static int start_point = 0;
    public static int end_point = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine().charAt(0);
        if(s<58) {
            start_point = 48;
            end_point = 57;
        } else if(s<91) {
            start_point = 65;
            end_point = 90;
        } else {
            start_point = 97;
            end_point = 122;
        }
        System.out.println(check(s, start_point, end_point));
    }

    public static int check(char s, int start_point, int end_point) {
        int result = -1;
        for(int i=start_point ; i<=end_point ; i++) {
            if(s==i) {
                result = i;
                break;
            }
        }
        return result;
    }
}
