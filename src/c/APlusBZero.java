package c;

import java.io.*;

public class APlusBZero {

    public static int a = 0;
    public static int b = 0;

    public static int hap = 0;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            while(true) {
                hap = testcase(bf.readLine().replaceAll(" ", "~"));
                if(hap==0) break; else bw.write(hap + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int testcase(String line) {
        String[] ab = line.split("~");
        a = Integer.parseInt(ab[0]);
        b = Integer.parseInt(ab[1]);
        return a + b;
    }
}
