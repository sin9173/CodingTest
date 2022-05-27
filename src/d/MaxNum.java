package d;

import java.io.*;
import java.util.stream.IntStream;

public class MaxNum {

    public static int num = 0;
    public static int max = -999;
    public static int max_seq = 0;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        IntStream.range(1, 10).forEach(i -> {
            try {
                num = Integer.parseInt(bf.readLine());
                if(num>max) {
                    max = num;
                    max_seq = i;
                }
                if(i==9) {
                    bw.write(max + "\n" + max_seq);
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
