package c;

import java.io.*;
import java.util.ArrayList;

public class APlusBCase {

    public static int count = 0;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            count = Integer.parseInt(bf.readLine());
            testcase(count, bf).stream().forEach(s -> {
                try {
                    bw.write(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> testcase(int count, BufferedReader bf) throws IOException {
        ArrayList<String> result = new ArrayList<>();

        for(int i=1 ; i<=count ; i++) {
            int[] nums = parse(bf.readLine());
            result.add("Case #" + (i) + ": " + (nums[0]) + " + " + (nums[1]) + " = " + (nums[0] + nums[1]) + "\n");
        }
        return result;
    }

    public static int[] parse(String line) {
        line = line.replaceAll(" ", "~");
        String[] split = line.split("~");
        int[] result = {Integer.parseInt(split[0]), Integer.parseInt(split[1])};
        return result;
    }
}
