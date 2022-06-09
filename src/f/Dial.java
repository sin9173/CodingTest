package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dial {
    public static String s = "";

    public static String[] array = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();

        for(int i=0 ; i<s.length() ; i++) {
            String c = s.substring(i, i+1);
            time++;
            for(int j=0 ; j<array.length ; j++) {
                time++;
                if(array[j].contains(c)) {
                    time++;
                    break;
                }
            }
        }
        System.out.println(time);
    }
}
