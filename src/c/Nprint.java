package c;

import java.io.*;

public class Nprint {

    public static int n = 0;

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            n = Integer.parseInt(bf.readLine());
            writer(n, bw);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writer(int n, BufferedWriter bw) throws IOException {
        for(int i=1 ; i<=n ; i++) bw.write(i + "\n");
    }
}
