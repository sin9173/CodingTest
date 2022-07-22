package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pibonachi {

    public static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        System.out.println(pi(n));
    }

    public static int pi(int n) {
        if(n==0 || n==1) return n;
        int[] array = {0, 1, 1};
        for(int i=3 ; i<=n ; i++) {
            array[0] = array[1];
            array[1] = array[2];
            array[2] = array[0] + array[1];
        }
        return array[2];
    }
}
