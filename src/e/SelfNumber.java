package e;

import java.util.HashSet;

public class SelfNumber {

    public static HashSet<Integer> set = new HashSet<>();

    public static int count = 10000;

    public static void main(String[] args) {
        for(int i=1 ; i<=count ; i++) noself(i);
        for(int i=1 ; i<=count ; i++) if(!set.contains(i)) System.out.println(i);
    }

    public static void noself(int a) {
        System.out.println(a);
        int result = 0;
        if(a<10) result = a + a;
        else {
            String str = String.valueOf(a);
            result = a;
            for(int i=0 ; i<str.length() ; i++) {
                System.out.print(str.substring(i, i+1) + " ");
                result += Integer.parseInt(str.substring(i, i+1));
            }
        }
        System.out.println("result : " + result);
        set.add(result);
    }
}
