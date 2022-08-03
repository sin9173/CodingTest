package p1;

import java.io.IOException;

public class NumberEnglish {

    public static String[] num_str = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
    public static String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    public static void main(String[] args) throws IOException {
        String s = "2three45sixseven";
        System.out.println(convert(s));
    }

    public static int convert(String s) {
        for(int i=0 ; i<nums.length ; i++) s = s.replaceAll(num_str[i], nums[i]);
        return Integer.parseInt(s);
    }
}
