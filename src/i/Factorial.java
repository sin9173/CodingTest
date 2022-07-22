package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {

    public static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if(n==0) return 1;
        int result = 1;
        for(int i=2 ; i<=n ; i++) {
            result = result * i;
        }
        return result;
    }
}
