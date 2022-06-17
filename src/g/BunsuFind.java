package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BunsuFind {

    public static int seq = 0;

    public static int count = 1;

    public static int flag = 0; //0:수평 1:수직

    public static int l = 1;
    public static int r = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        seq = Integer.parseInt(bf.readLine());
        while(true) {
            if(seq<=count) break;
            if(flag==0) {
                r++;
                if(l==1) flag = 1; else l--;
            } else {
                l++;
                if(r==1) flag = 0; else r--;
            }
            count++;
        }
        System.out.println(l + "/" + r);
    }
}
