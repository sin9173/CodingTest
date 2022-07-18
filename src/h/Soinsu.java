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
        list = mergeSort(list);
        for(int i : list) System.out.println(i);
    }

    public static int dist(int num) {
        for(int i=2 ; i<=(num/2) ; i++) if(num%i==0) return i;
        return num;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int al = 0;
        int bl = 0;

        for(int i=0 ; i<a.size()+b.size() ; i++) {
            if(al==a.size()) {
                result.add(b.get(bl));
                bl++;
                continue;
            }else if (bl==b.size()) {
                result.add(a.get(al));
                al++;
                continue;
            }
            if(a.get(al)<b.get(bl)) {
                result.add(a.get(al));
                al++;
            } else {
                result.add(b.get(bl));
                bl++;
            }
        }
        return result;
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
        if(list.size()<=1) {
            return list;
        } else {
            ArrayList<Integer> temp_a = new ArrayList<Integer>() {{ addAll(list.subList(0, list.size()/2));}};
            ArrayList<Integer> temp_b = new ArrayList<Integer>() {{ addAll(list.subList(list.size()/2, list.size()));}};

            ArrayList<Integer> a = mergeSort(temp_a);
            ArrayList<Integer> b = mergeSort(temp_b);

            return merge(a, b);
        }
    }
}
