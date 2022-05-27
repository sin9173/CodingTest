package c;

import java.io.*;
import java.util.ArrayList;

public class APlusBRepid {

    public static int count = 0;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            count = Integer.parseInt(bf.readLine());
            testcase(count, bf).stream().forEach(i -> {
                try {
                    bw.write(i + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> testcase(int count, BufferedReader bf) throws IOException {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] split = null;
        String temp = null;
        for(int i=0 ; i<count ; i++) {
            temp = bf.readLine();
            temp = temp.replaceAll(" ", "~");
            split = temp.split("~");
            result.add(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }

        return result;
    }
}
