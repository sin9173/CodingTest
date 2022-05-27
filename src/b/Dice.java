package b;

import java.util.*;

public class Dice {

    public static int a = 0;
    public static int b = 0;
    public static int c = 0;

    public static int dup = 0;
    public static int max = 0;
    public static int dup_count = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        System.out.println(calc(Arrays.asList(a, b, c)));
    }

    public static int calc(List<Integer> list) {
        int result = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        list.stream().forEach(i -> {
            if(set.contains(i)) {
                dup_count++;
                dup = i;
            }
            if(i>max) max = i;
            set.add(i);
        });

        switch (dup_count) {
            case 0 :
                result = max * 100;
                break;
            case 1 :
                result = 1000 + (dup * 100);
                break;
            case 2 :
                result = 10000 + (dup * 1000);
                break;
        }

        return result;
    }
}
