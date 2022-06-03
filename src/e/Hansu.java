package e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Hansu {

    public static int count = 0;
    public static int hansu_count = 0;

    public static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        for(int i=1 ; i<=count ; i++) if(hansu(i)) hansu_count++;

        System.out.println(hansu_count);
    }

    public static boolean hansu(int a) {
        if(a<100) return true;
        boolean result;
        String str = String.valueOf(a);
        for(int i=0 ; i<str.length()-1 ; i++) set.add(Integer.parseInt(str.substring(i+1, i+2)) - Integer.parseInt(str.substring(i, i+1)));
        result = set.size()==1?true:false;
        set.clear();
        return result;
    }
}
