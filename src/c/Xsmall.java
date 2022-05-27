package c;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Xsmall {

    public static int count = 0;
    public static int max = 0;

    public static String fir_str = "";
    public static String sec_str = "";

    public static String result = "";

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            fir_str = bf.readLine().replaceAll(" ", "~");
            sec_str = bf.readLine().replaceAll(" ", "~");

            String[] split1 = fir_str.split("~");
            String[] split2 = sec_str.split("~");

            count = Integer.parseInt(split1[0]);
            max = Integer.parseInt(split1[1]);

            Arrays.asList(split2).stream().forEach(s -> {
                if(Integer.parseInt(s)<max) result = result + (s + " ");
            });
            bw.write(result.substring(0, result.length()-1));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
