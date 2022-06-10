package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KroaTia {

    public static String[] kroas = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static String s = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        for(int i=0 ; i<kroas.length ; i++) s = s.replaceAll(kroas[i], "|");
        System.out.println(s.length());
    }
}
