package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class WordStudy {

    public static String s = "";
    public static int max = 0;
    public static int max_count = 0;
    public static String max_str = "";
    public static HashMap<String, Integer> word_map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine().toUpperCase();
        input();
        parse();
    }

    public static void input() {
        for(int i=0 ; i<s.length() ; i++) {
            String word = s.substring(i, i+1);
            int count;
            try {
                count = word_map.get(word);
            } catch (NullPointerException e) {
                count = 0;
            }
            if(count==0) word_map.put(word, 1);
            else word_map.put(word, count+1);
            if((count+1)>max) {
                max = count + 1;
                max_str = word;
            }
        }
    }

    public static void parse() {
        Set<String> keys = word_map.keySet();

        Iterator<String> iterator = keys.iterator();

        while(iterator.hasNext()) {
            String str = iterator.next();
            if(max==word_map.get(str)) max_count++;
        }

        if(max_count>1) System.out.println("?");
        else System.out.println(max_str);
    }
}
