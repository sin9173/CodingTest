package k;

import java.io.IOException;
import java.util.Arrays;

public class MergeSort2 {

    public static int count = 0;
    public static int[] list = {};

    public static void main(String[] args) throws IOException {
        int[] list = {10, 4, 3, 9, 11, 56, 32, 21, 5};
        list = mergeSort(list);

        for(int i = 0; i<list.length ; i++) {
            System.out.print(list[i] + ", ");
        }
    }

    public static int[] mergeSort(int[] list) {
        if(list.length==1) return list;
        int[] list1 = mergeSort(Arrays.copyOfRange(list, 0, list.length/2));
        int[] list2 = mergeSort(Arrays.copyOfRange(list, list.length/2, list.length));
        return merge(list1, list2);
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] result = new int[list1.length + list2.length];
        int a = 0;
        int b = 0;

        for(int i=0 ; i<result.length ; i++) {
            if(a==list1.length) {
                result[i] = list2[b];
                b++;
                continue;
            } else if(b==list2.length) {
                result[i] = list1[a];
                a++;
                continue;
            }

            if(list1[a]<list2[b]) {
                result[i] = list1[a];
                a++;
            } else {
                result[i] = list2[b];
                b++;
            }
        }

        return result;
    }
}
