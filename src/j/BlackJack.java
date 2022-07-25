package j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BlackJack {

    public static int count = 0;
    public static int max = 0;

    public static ArrayList<Integer> array = new ArrayList<>();

    public static HashSet<Integer> set = new HashSet<>();

    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split1 = bf.readLine().replaceAll(" ", "~").split("~");
        String[] split2 = bf.readLine().replaceAll(" ", "~").split("~");

        count = Integer.parseInt(split1[0]);
        max = Integer.parseInt(split1[1]);

        for(String s : split2) array.add(Integer.parseInt(s));

        System.out.println(array);

        brute();

        System.out.println(result);
    }


    public static void brute() {
        for(int i=0 ; i<array.size() ; i++) {
            for(int j=1 ; j<array.size() ; j++) {
                for(int k=2 ; k<array.size() ; k++) {
                    set.clear();
                    set.add(i);
                    set.add(j);
                    set.add(k);

                    System.out.println("i : " + i + ", j : " + j + ", k : " + k);
                    System.out.println("size1 : " + set.size());

                    if(set.size()!=3) continue;

                    int hap = array.get(i) + array.get(j) + array.get(k);

                    System.out.println("a : " + array.get(i) + ", b : " + array.get(j) + ", c : " + array.get(k) +  ", Hap : " + hap);

                    if(hap<=max && hap>result) result = hap;
                    System.out.println("size2 : " + set.size());
                }
            }
        }
    }
}
