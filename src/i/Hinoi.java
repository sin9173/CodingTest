package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Hinoi {

    public static int input = 0;

    public static ArrayList<String> result = new ArrayList<>();

    public static int before = 0;
    public static int after = 0;

    public static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
    public static HashSet<String> log = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(bf.readLine());
        array.add(new ArrayList<Integer>());
        array.add(new ArrayList<Integer>());
        array.add(new ArrayList<Integer>());


        for(int i=0 ; i<input ; i++) stackIn(0, input-i);
        System.out.println(array);
        System.out.println(stackSize(0));

        move();

    }

    public static void move() {
        for(int i=0 ; i<=2 ; i++) {
            for(int j=2 ; j>=0 ; j--) {
                if(stackSize(i)==0) continue;
                if(i==j) continue;
                if(stackView(2)==1 && stackSize(2)==input) return;
                int a = stackView(i);
                int b = stackView(j);
                if(stackSize(j)==0 || a<b) {
                    int temp = stackOut(i);
                    stackIn(j, temp);
                    if(log.contains(array.toString())) {
                        temp = stackOut(j);
                        stackIn(i, temp);
                    } else {
                        log.add(array.toString());
                    }
                    System.out.println(array);
                }
            }
        }
        move();
    }

    public static void stackIn(int loc, int a) {
        array.get(loc).add(a);
    }

    public static int stackOut(int loc) {
        if(array.get(loc).size()==0) return 0;
        ArrayList<Integer> a = array.get(loc);
        int result = a.get(a.size()-1);
        a.remove(a.size()-1);
        return result;
    }

    public static int stackView(int loc) {
        if(array.get(loc).size()==0) return 0;
        ArrayList<Integer> a = array.get(loc);
        return a.get(a.size()-1);
    }

    public static int stackSize(int loc) {
        return array.get(loc).size();
    }


}
