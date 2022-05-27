package d;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Maxmin {

    public static String fir_str = "";
    public static String sec_str = "";

    public static int[] list = {};


    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            fir_str = bf.readLine();
            sec_str = bf.readLine().replaceAll(" ", "~");

            String[] split = sec_str.split("~");

            list = new int[Integer.parseInt(fir_str)];

            IntStream.range(0, list.length).forEach(i -> list[i] = Integer.parseInt(split[i]));

            list = mergeSort(list);

            bw.write(list[0] + " " + list[list.length-1]);
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int[] merge(int[] a, int[] b) {
        int[] newArr = new int[a.length + b.length];
        int al = 0;
        int bl = 0;

        for(int i=0 ; i<newArr.length ; i++ ) {
            if(al>=a.length) {
                newArr[i] = b[bl];
                bl++;
                continue;
            } else if(bl>=b.length) {
                newArr[i] = a[al];
                al++;
                continue;
            }

            if(a[al]<b[bl]) {
                newArr[i] = a[al];
                al++;
            } else {
                newArr[i] = b[bl];
                bl++;
            }
        }
        return newArr;
    }

    public static int[] mergeSort(int[] list) {
        if(list.length<=1) {
            return list;
        } else {
            int[] a = mergeSort(Arrays.copyOfRange(list, 0, list.length/2));
            int[] b = mergeSort(Arrays.copyOfRange(list, list.length/2, list.length));
            return merge(a, b);
        }
    }


}
