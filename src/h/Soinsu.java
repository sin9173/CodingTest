package h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Soinsu {
    public static int num = 0;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        while(num>1) {
            int soinsu = dist(num);
            num = num/soinsu;
            list.add(soinsu);
        }
        for(int i : list) System.out.println(i);
    }

    public static int dist(int num) {
        for(int i=2 ; i<(num/2) ; i++) if(num%i==0) return i;
        return num;
    }
}
