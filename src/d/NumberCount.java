package d;

import java.io.*;

public class NumberCount {

    public static int a = 0;
    public static int b = 0;
    public static int c = 0;

    public static int mul = 0;

    public static String mul_str = "";

    public static int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        a = Integer.parseInt(bf.readLine());
        b = Integer.parseInt(bf.readLine());
        c = Integer.parseInt(bf.readLine());

        mul = a * b * c;

        mul_str = String.valueOf(mul);

        for(int i=0 ; i<mul_str.length() ; i++) {
            int point = Integer.parseInt(mul_str.substring(i, i+1));
            nums[point] += 1;
        }

        for(int i=0 ; i<nums.length ; i++) bw.write(nums[i] + "\n");

        bw.flush();
        bw.close();

    }
}
