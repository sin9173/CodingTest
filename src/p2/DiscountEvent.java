package p2;

import java.util.HashMap;

public class DiscountEvent {

    public static HashMap<String, Integer> count_map = new HashMap<>();

    public static int start = 0;
    public static int end = 9;

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        init(discount);

        System.out.println(calc(want, number, discount));
    }

    public static int calc(String[] want, int[] number, String[] discount) {
        int count = 0;

        while(true) {
            System.out.println("start : " + start + ", end : " + end + ", count_map : " + count_map);
            boolean flag = true;
            for(int i=0 ; i<want.length ; i++) {
                Integer temp = count_map.get(want[i]);
                if(temp==null) {
                    flag = false;
                    break;
                } else {
                    if(temp-number[i]<0) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) count++;
            if(end==(discount.length - 1)) break;
            nextDay(discount);
        }

        return count;
    }

    public static void init(String[] discount) {
        for(int i=0 ; i<10 ; i++) {
            Integer temp = count_map.get(discount[i]);
            if(temp==null) {
                count_map.put(discount[i], 1);
            } else {
                count_map.put(discount[i], temp+1);
            }
        }
    }

    public static void nextDay(String[] discount) {
        Integer old = count_map.get(discount[start]);
        count_map.put(discount[start], old-1);
        start++;
        end++;

        Integer temp = count_map.get(discount[end]);
        if(temp==null) {
            count_map.put(discount[end], 1);
        } else {
            count_map.put(discount[end], temp+1);
        }
    }


}
