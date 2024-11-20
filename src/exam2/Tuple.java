package exam2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Tuple {

    public static HashMap<Integer, Integer> map = new HashMap<>();
    public static ArrayList<Tup> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        parse(s);
        toList();

        System.out.println(map);

        System.out.println(list);

        heapSort();

        System.out.println(list);
    }

    public static int[] array() {
        int[] arr = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) {
            arr[i] = list.get(i).n;
        }

        return arr;
    }

    public static void heapSort() {
        Tup temp;
        for(int i=(list.size()-1) ; i>0 ; i--) {
            heap(i);
            temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
        }
    }

    public static void heap(int i) {
        int search;
        int root;
        Tup temp;

        for( ; i>=0 ; i--) {
            search = i;
            System.out.println("i : " + i);
            while(search>0) {
                root = (search-1)/2;
                if(list.get(search).count < list.get(root).count) {
                    temp = list.get(search);
                    list.set(search, list.get(root));
                    list.set(root, temp);
                    search = root;
                    System.out.println("search : " + search + ", root : " + root);
                    System.out.println(list);
                } else {
                    break;
                }
            }
        }
    }

    public static void parse(String s) {
        String temp;
        Integer c;
        Integer n;

        s = s.replaceAll("\\{", "");
        s = s.replaceAll("}", "");

        String[] split = s.split(",");

        for(int i=0 ; i<split.length ; i++) {
            temp = split[i];
            n = Integer.parseInt(temp);
            c = map.get(n);
            if(c==null) map.put(n, 1);
            else map.put(n, c+1);
        }
    }

    public static void toList() {
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();

        Integer key;

        while(iterator.hasNext()) {
            key = iterator.next();
            Tup tup = new Tup(key, map.get(key));
            list.add(tup);
        }
    }


}

class Tup {
    public int n;
    public int count;

    public Tup(int n, int count) {
        this.n = n;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tup{" +
                "n=" + n +
                ", count=" + count +
                '}';
    }
}
