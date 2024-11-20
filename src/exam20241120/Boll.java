package exam20241120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Boll {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] basketSplit = br.readLine().split(" ");

        int basketCount = Integer.parseInt(basketSplit[0]);
        int dropCount = Integer.parseInt(basketSplit[1]);

        int[] basket = new int[basketCount];

        for(int i=1 ; i<=dropCount ; i++) {
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int number = Integer.parseInt(split[2]);
            for(int j=start ; j<=end ; j++) {
                basket[j-1] = number;
            }
        }

        String collect = Arrays.stream(basket).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
