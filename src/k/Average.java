package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Average {

    private static int count = 0;

    private static int[] array = {};

    private static int average = 0;

    private static int middle = 0;

    private static int mode = 0;

    private static int range = 0;

    private static int max = 0;

    private static int min = 5000;

    private static int min_sec = 5000;

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        array = new int[count];
        for(int i=0 ; i<count ; i++) array[i] = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<count ; i++) {
            setAverage(array[i], i);
            setMiddle(array[i], i);
            compare(array[i]);
            setCount(array[i]);
        }

        range = setRange();
        mode = setMode();

        System.out.println(average);
        System.out.println(middle);
        System.out.println(mode);
        System.out.println(range);
    }

    //ROOF
    public static void setAverage(int num, int i) {
        average += num;
        if(i==(count-1)) average = average/count;
    }

    public static void setMiddle(int num, int i) {
        if(i==count/2) middle = num;
    }

    public static void compare(int num) {
        if(num<min) min=num;
        if(num>min && num<min_sec) min_sec = num;
        if(num>max) max = num;
    }

    public static void setCount(int num) {
        if(map.get(num)==null) map.put(num, 1);
        else map.put(num, map.get(num) + 1);
    }

    //
    public static int setRange() {
        return max - min;
    }

    public static int setMode() {
        if(count==1) return array[0];
        int max_count = 1;
        int max_num = 0;
        for(int i=0 ; i<count ; i++) {
            int num = array[i];
            int num_count = map.get(num);
            if(num_count>max_count) {
                max_count = num_count;
                max_num = num;
            }
        }
        if(max_count==1) max_num = min_sec;
        return max_num;
    }
}
