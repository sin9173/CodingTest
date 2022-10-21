package exam2;

import java.util.ArrayList;

public class PrimeK {

    public static ArrayList<Long> list = new ArrayList<Long>();

    public static void main(String[] args) {
        int n = 437674;
        int k = 3;

        String convert = convert(n, k);
        System.out.println("convert : " + convert);
        filter(convert);

        System.out.println(check(list));

    }

    public static int check(ArrayList<Long> list) {
        long max = 0;
        int count = 0;

        int point = 0;

        for(int i=0 ; i<list.size() ; i++) {
            if(list.get(i)>max) max = list.get(i);
        }

        long[] arr = new long[Math.toIntExact(max + 1)];

        for(long i=2 ; i<max-1 ; i++) {
            for(long j=i ; j<max ; j+=j) {
                if(i!=j) {
                    arr[Math.toIntExact(j)] = 1;
                    count++;
                }
            }
        }

        long[] arr2 = new long[Math.toIntExact(max)];
        count = 0;

        for(long i=2 ; i<arr.length ; i++) {
            if(arr[Math.toIntExact(i)]==0) {
                arr2[point] = i;
                point++;
            }
        }

        printArray(arr2);

        for(int i=2 ; i<list.size() ; i++) {
            Long temp = new Long(list.get(i));
            for(int j=0 ; j<arr2.length ; j++) {
                if(temp.equals(new Long(arr2[j]))) count++;
            }
        }

        return count;
    }

    public static void filter(String convert) {
        StringBuilder sb = new StringBuilder();
        char temp;
        for(int i=0 ; i<convert.length() ; i++) {
            temp = convert.charAt(i);
            System.out.println("temp : " + temp);
            if(temp=='0') {
                System.out.println("sb : " + sb);
                if(sb.length()>0 &&(!sb.equals("") || !sb.equals(" "))) {
                    list.add(Long.parseLong(sb.toString()));
                }
                sb.delete(0, sb.length());
                continue;
            }
            sb.append(temp);
        }

        if(sb.length()>0 && (!sb.equals("") || !sb.equals(" ")))list.add(Long.parseLong(sb.toString()));
        System.out.println(list);
    }

    public static String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n>=k) {
            sb.insert(0, n%k);
            n = n/k;
        }
        if(n>0) sb.insert(0, n);
        return sb.toString();
    }

    //배열출력
    public static void printArray(long[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
