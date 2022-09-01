package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Statistics {

    public static ArrayList<Integer> nums = new ArrayList<>();

    public static int count = 0;

    public static long average = 0;

    public static int center = 0;

    public static int max_count_value = 0;

    public static ArrayList<Integer> max_count_list = new ArrayList<>();

    public static int scope = 0;

    public static HashMap<Integer, Integer> count_map = new HashMap<Integer, Integer>();

    public static void main(String[] args) throws IOException {
        init();
        countSort();
        check();
        print();
    }

    public static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<count ; i++) nums.add(Integer.parseInt(bf.readLine()));
    }

    public static void countSort() {
        int point = 0;

        for(int i=0 ; i<nums.size() ; i++) {
            Integer c = count_map.get(nums.get(i));
            if(c==null) count_map.put(nums.get(i), 1);
            else count_map.put(nums.get(i), c+1);
        }

        System.out.println(count_map);

        for(int i=(-4000) ; i<=4000 ; i++) {
            Integer count = count_map.get(i);
            if(count==null) continue;
            for(int j=1 ; j<=count ; j++) {
                nums.set(point, i);
                point++;
            }
        }

        System.out.println(nums);
    }

    public static void check() {
        double hap = 0;

        int max = -999999;

        int min = 999999;

        int max_count = 0;

        for(int i=0 ; i<nums.size() ; i++) {
            int num = nums.get(i);
            hap += num;
            Integer count = count_map.get(num);
            if(count!=null && count>=max_count) {
                if(count>max_count) {
                    max_count_list.clear();
                    max_count = count;
                }
                max_count_list.add(num);
            }

            if(num>max) max = num;
            if(num<min) min = num;
        }

        max_count_value = max_count_list.get(0);
        for(int i=0 ; i<max_count_list.size() ; i++) {
            if(max_count_value!=max_count_list.get(i)) {
                max_count_value = max_count_list.get(i);
                break;
            }
        }

        System.out.println("Hap : " + hap);
        System.out.println("Max : " + max);
        System.out.println("Min : " + min);
        System.out.println("max_count : " + max_count);
        System.out.println("max_count_list : " + max_count_list);

        average = Math.round(hap/count);
        center = nums.get(count/2);
        scope = max-min;
    }

    public static void print() {
        System.out.println(average);
        System.out.println(center);

        System.out.println(max_count_value);
        System.out.println(scope);
    }
}
