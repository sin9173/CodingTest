package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunHeaHap {

    public static int input = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        input = Integer.parseInt(bf.readLine());

        System.out.println(brute(input));
    }

    public static int brute(int num) {
        int result = 0;
        for(int i=(num - (num/2)) ; i<num ; i++) {
            String[] split = String.valueOf(i).split("");
            int hap = i;
            for(int j=0 ; j<split.length ; j++) {
                hap += Integer.parseInt(split[j]);
            }
            if(num==hap) return i;
        }
        return result;
    }
}
