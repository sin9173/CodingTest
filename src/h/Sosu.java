package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sosu {

    public static int result_count = 0;
    public static int count = 0;
    public static String[] nums = {};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        nums = bf.readLine().replaceAll(" ", "~").split("~");

        for(int i=0 ; i<nums.length ; i++) {
            if(check(Integer.parseInt(nums[i]))) result_count++;
        }

        System.out.println(result_count);
    }

    public static boolean check(int num) {
        if(num==1) return false;
        int a = num/2;

        while(a>1) {
            if(num%a==0) return false;
            else a--;
        }
        return true;
    }
}
