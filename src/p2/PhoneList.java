package p2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class PhoneList {

    public static HashMap<String, Integer> map = new HashMap<String, Integer>();
    public static HashSet<Integer> lengths = new HashSet<>();

    public static void main(String[] args) {
        String[] phone_book = {"119", "1191111"};
        init(phone_book);
        System.out.println(check(phone_book));
    }

    public static boolean check(String[] phone_book) {
        int[] length_arr = new int[lengths.size()];
        Iterator<Integer> iterator = lengths.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            length_arr[i] = iterator.next();
            i++;
        }
        for(i=0 ; i<phone_book.length ; i++) {
            for(int j=0 ; j<length_arr.length ; j++) {
                if(phone_book[i].length()<length_arr[j]) continue;
                Integer index = map.get(phone_book[i].substring(0, length_arr[j]));
                if(index!=null && index!=i) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void init(String[] phone_book) {
        for(int i=0 ; i<phone_book.length ; i++) {
            map.put(phone_book[i], i);
            lengths.add(phone_book[i].length());
        }

        System.out.println(map);
        System.out.println(lengths);
    }
}
