package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {

    public static int count = 0;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        stringBuilder.append((int)(Math.pow(2, count)-1)).append("\n");

        hanoi(count, 1, 2, 3);

        System.out.println(stringBuilder);
    }

    public static void hanoi(int n, int a, int b, int c) {
        if(n==1) {
            stringBuilder.append(a + " " + c + "\n");
            return;
        }

        hanoi(n-1, a, c, b);

        stringBuilder.append(a + " " + c + "\n");

        hanoi(n-1, b, a, c);
    }
}
