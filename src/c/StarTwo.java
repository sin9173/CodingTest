package c;

import java.io.*;

public class StarTwo {

    public static int count = 0;

    public static String star = "";

    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            count = Integer.parseInt(bf.readLine());
            for(int i=1 ; i<=count ; i++) {
                star = star + "*";
                bw.write((new String(new char[count - i]).replaceAll("\0", " ")) + star + "\n" );
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
