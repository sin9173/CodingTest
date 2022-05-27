package c;

import java.io.*;

public class APlusBException {

    public static int a = 0;
    public static int b = 0;

    public static int hap = 0;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            try {
                hap = testcase(bf.readLine().replaceAll(" ", "~"));
                bw.write(hap + "\n");
            } catch(Exception e) {
                e.printStackTrace();
                break;
            }
        }
        try {
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int testcase(String line) throws Exception {
        String[] split = line.split("~");
        a = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);
        return a + b;
    }
}
