package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Oxquiz {

    public static ArrayList<String> list = new ArrayList<>();

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<count ; i++) list.add(bf.readLine());

        for(int i=0 ; i<list.size() ; i++) System.out.println(calc(list.get(i), 0));
    }

    public static int calc(String mun, int hap) {
        String[] split = mun.split("X");
        for(int i=0 ; i<split.length ; i++) {
            if(split[i].equals("")) continue;
            System.out.println(split[i].length());
            hap += ((split[i].length() + 1) * split[i].length()) / 2;
        }
        return hap;
    }
}
