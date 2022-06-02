package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class AverageRate {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        count = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<count ; i++) {
            HashMap<String, Object> map = getMap(bf.readLine().replaceAll(" ", "~"));
            double result = ( (double)((ArrayList<Double>)map.get("big_list")).size() / (double)map.get("count") ) * 100;
            System.out.println(String.format("%.3f", result) + "%");
        }
    }

    public static HashMap<String, Object> getMap(String line) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        String[] split = line.split("~");
        ArrayList<Integer> jumsu_list = new ArrayList<Integer>();
        ArrayList<Integer> big_list = new ArrayList<Integer>();

        int hap = 0;

        double count = Double.parseDouble(split[0]);

        for(int i=1 ; i<split.length ; i++) {
            int jum = Integer.parseInt(split[i]);
            jumsu_list.add(jum);
            hap += jum;
        }

        double average = hap/count;

        for(int i=0 ; i<jumsu_list.size() ; i++) if(average<jumsu_list.get(i)) big_list.add(jumsu_list.get(i));

        result.put("count", count);
        //result.put("list", jumsu_list);
        //result.put("hap", hap);
        //result.put("average", average);
        result.put("big_list", big_list);

        return result;
    }
}
