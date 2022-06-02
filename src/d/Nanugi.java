package d;

import java.io.*;
import java.util.HashSet;

public class Nanugi {

    private static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i<10 ; i++) set.add(Integer.parseInt(bf.readLine())%42);
        System.out.println(set.size());
    }
}
