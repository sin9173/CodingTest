package g;

import java.io.*;

public class DalPangiUp {

    public static long speed = 0;
    public static long slide = 0;
    public static long height = 0;

    public static long result = 0;

    public static long average = 0;

    public static String[] nums = {};

    public static long ca = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        nums = bf.readLine().replaceAll(" ", "~").split("~");
        speed = Integer.parseInt(nums[0]);
        slide = Integer.parseInt(nums[1]);
        height = Integer.parseInt(nums[2]);

        if(height<=speed) {
            System.out.println(1);
        } else {
            average = speed - slide;
            //System.out.println("average : " + average);
            //System.out.println("1 : " + speed/average);

            result = height/average;
            result = (result * average)<height?result+1:result;

            System.out.println("result 계산전 : " + result);

            ca = (average * (result - 1)) + slide;

            result = ca + slide >= height?result-(speed/average - (speed%average>0&&height%average>0?0:1)):result;

            //System.out.println("2 : " + (result * average));
            //System.out.println("3 : " + (average * (result - 1)));

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
        }
    }
}
