package k;

import java.io.*;
import java.util.ArrayList;

public class InsertSort {

    public static int count = 0;
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<count ; i++) list.add(Integer.parseInt(bf.readLine()));

        list = insertSort(list);

        System.out.println(list);

        list.forEach(i -> sb.append(i + "\n"));

        System.out.println(sb);
    }

    public static ArrayList<Integer> insertSort(ArrayList<Integer> list) {
        int flag = 0;
        for(int i=1 ; i<list.size() ; i++) {
            int key = list.get(i);
            int loc = 0;
            for(int j=(i-1) ; j>=0 ; j--) {
                if(key<=list.get(j)) {
                    list.set(j+1, list.get(j));
                    flag = 1;
                } else {
                    loc = j + 1;
                    break;
                }
            }
            list.set(loc, key);
        }
        if(flag==0) return list;
        return insertSort(list);
    }
}
