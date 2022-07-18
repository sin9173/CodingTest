package g;

import java.io.*;

public class DalPangiUp2 {

    public static long speed = 0;
    public static long slide = 0;
    public static long height = 0;

    public static long total_height = 0;

    public static long result = 0;

    public static long average = 0;

    public static String[] nums = {};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        nums = bf.readLine().replaceAll(" ", "~").split("~");
        speed = Integer.parseInt(nums[0]);
        slide = Integer.parseInt(nums[1]);
        total_height = Integer.parseInt(nums[2]);
        height = total_height - speed;

        if(total_height<=speed) {
            System.out.println(1);
        } else {
            average = speed - slide;
            result = height/average;
            result = (result * average)<height?result+1:result;
            bw.write(String.valueOf(result+1));
            bw.flush();
            bw.close();
        }
    }
}
