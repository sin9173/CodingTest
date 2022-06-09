package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NSummary {

    public static int count = 0;
    public static String num_str = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bf.readLine());
        num_str = bf.readLine();

        System.out.println(calc(num_str.split(""), count));
    }

    public static int calc(String[] nums, int count) {
        int result = 0;
        for(int i=0 ; i<count ; i++) result += Integer.parseInt(nums[i]);
        return result;
    }
}
