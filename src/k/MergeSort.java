package k;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

    public static int count = 0;
    public static List<Integer> list = new LinkedList<>();

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        list = mergeSort(Arrays.asList(3, 2, 5, 1, 10, 8, 8, 20, 16, 30));
        System.out.println(list);
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        System.out.println(list + " size : " + list.size());
        if(list.size()==1) return list;
        System.out.println("분할");
        List<Integer> list1 = mergeSort(list.subList(0, list.size()/2));
        List<Integer> list2 = mergeSort(list.subList(list.size()/2, list.size()));

        return merge(list1, list2);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        System.out.println("안녕 머지");
        List<Integer> result = new LinkedList<>();
        int a = 0;
        int b = 0;
        for(int i=0 ; i<(list1.size() + list2.size()) ; i++) {

            if(a==list1.size()) {
                result.add(list2.get(b));
                b++;
                continue;
            } else if(b==list2.size()) {
                result.add(list1.get(a));
                a++;
                continue;
            }

            if(list1.get(a) < list2.get(b)) {
                result.add(list1.get(a));
                a++;
            } else {
                result.add(list2.get(b));
                b++;
            }
        }
        System.out.println("result : " + result);
        return result;
    }
}
