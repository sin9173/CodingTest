package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BubbleSort {

    public static int count = 0;
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<count ; i++) list.add(Integer.parseInt(bf.readLine()));

        list = bubbleSort(list);

        System.out.println(list);

        list.forEach(i -> sb.append(i + "\n"));

        System.out.println(sb);
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        int flag = 0;
        for(int i=0 ; i<(list.size()-1) ; i++) {
            int a = list.get(i);
            int b = list.get(i+1);

            if(a>b) {
                int temp = list.get(i);
                list.set(i, list.get(i+1));
                list.set(i+1, temp);
                flag = 1;
            }
        }
        System.out.println(list);
        if(flag==0) return list;
        return bubbleSort(list);
    }
}
