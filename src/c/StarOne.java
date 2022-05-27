package c;

import java.io.*;

public class StarOne {

    public static int a = 0;

    public static String star = "";

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            a = Integer.parseInt(bf.readLine());
            for(int i=0 ; i<a ; i++) {
                star = star + "*";
                bw.write(star + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
