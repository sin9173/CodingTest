package h;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Goldbach {

    public static int test_case = 0;

    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        test_case = Integer.parseInt(bf.readLine());

        for(int i=1 ; i<=test_case ; i++) list.add(Integer.parseInt(bf.readLine()));

        for(int num : list) {
            HashSet elem = get_elem(num);
            int[] result = get_partition(elem, num);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int[] get_partition(HashSet<Integer> elem, int num) {
        int[] result = new int[2];
        int half = num!=4&&((num/2)%2==0)?((num/2)-1):(num/2);
        for(int i=half ; i>0 ; i-=2) {
            if(!elem.contains(i)) continue;
            if(!elem.contains(num-i)) continue;
            System.out.println(" a = " + i + ", b = " + (num-i));
            result[0] = i;
            result[1] = num-i;
            break;
        }
        return result;
    }

    public static HashSet<Integer> get_elem(int num) {
        int flag = 3;
        HashSet<Integer> elem = new HashSet<Integer>();
        for(int i=1 ; i<num ; i++) {
            if(Arrays.asList(1, 2, 3).contains(i)) elem.add(i);
            if(i%2!=0) elem.add(i);
        }
        while (true) {
            for(int i=(flag * 2) ; i<num ; i+=flag) elem.remove(i);
            if(flag>=num/2) break;
            flag += 2;
        }
        System.out.println("숫자 존재 여부1 : " + elem.contains(4999));
        System.out.println("숫자 존재 여부2 : " + elem.contains(5001));
        System.out.println(elem);
        return elem;
    }
}
