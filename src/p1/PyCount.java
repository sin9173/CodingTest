package p1;

import java.util.HashMap;

public class PyCount {

    public static void main(String[] args) {
        String s = "";
        HashMap<String, Integer> count_map = counting(s);
        int p_count = count_map.get("P");
        int y_count = count_map.get("Y");
    }

    public static HashMap<String, Integer> counting(String s) {
        s = s.toUpperCase();
        String[] split = s.split("");
        HashMap<String, Integer> count_map = new HashMap<>();
        for(int i=0 ; i<split.length ; i++) {
            Integer count = count_map.get(split[i]);
            count_map.put(split[i], count==null?1:count+1);
        }
        return count_map;
    }
}
