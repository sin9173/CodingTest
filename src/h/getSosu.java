package h;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class getSosu {

    public static int a;
    public static int b;

    public static String[] split = null;

    public static ArrayList<Integer> result_list = new ArrayList<Integer>();

    public static int state = 1;
    public static int flag = 0;
    public static HashSet<Integer> num_set = new HashSet<Integer>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        split = bf.readLine().replaceAll(" ", "~").split("~");
        a = Integer.parseInt(split[0]);
        b = Integer.parseInt(split[1]);
        for(int i=a ; i<=b ; i++) num_set.add(i);
        num_set.remove(1);
        che();
        Iterator<Integer> iterator = num_set.iterator();
        while(iterator.hasNext()) result_list.add(iterator.next());

        result_list = mergeSort(result_list);

        for(int result : result_list) bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    public static void che() {
        while(true) {
            if(flag==2) flag++; else flag += 2;
            state = 0;
            System.out.println("flag : " + flag);
            for(int i=(flag*2) ; i<=b ; i+=flag) {
                if(num_set.remove(i)) state=1;
            }
            if(state==0 && flag>=(b/2)) return;
        }
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
            } else if (bl==b.size()) {
                result.add(a.get(al));
                al++;
                continue;
            }

            if(a.get(al) < b.get(bl)) {
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
            ArrayList<Integer> temp_a = new ArrayList<Integer>() {{ addAll(list.subList(0, list.size()/2)); }};
            ArrayList<Integer> temp_b = new ArrayList<Integer>() {{ addAll(list.subList(list.size()/2, list.size())); }};

            ArrayList<Integer> a = mergeSort(temp_a);
            ArrayList<Integer> b = mergeSort(temp_b);

            return merge(a, b);
        }
    }

}
