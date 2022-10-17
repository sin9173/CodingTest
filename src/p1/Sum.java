package p1;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        Integer[] arr = list.stream().toArray(Integer[]::new);
        int a = 5;
        int b = 3;
        System.out.println(sum(a, b));
    }

    public static long sum(int a, int b) {
        long count = a<b?(b - a) + 1:(a - b) + 1;
        long middle = count%2==0?0:(a + b)/2;
        return ((a+b) * (count/2) ) + middle;
    }
}
