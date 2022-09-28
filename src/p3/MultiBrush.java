package p3;

import java.util.HashMap;

public class MultiBrush {

    public static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
    public static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
    public static String[] seller = {"young", "john", "tod", "emily", "mary"};
    public static int[] amount = {12, 4, 2, 5, 10};

    public static HashMap<String, Integer> result_map = new HashMap<String, Integer>();
    public static HashMap<String, Integer> index_map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        initMap(enroll);

        for(int i=0 ; i<seller.length ; i++) {
            calc(seller[i], amount[i]);
        }

        int[] arr = getList();

        printArray(arr);
    }

    //등록자 인덱스 초기화
    public static void initMap(String[] enroll) {
        for(int i=0 ; i<enroll.length ; i++) {
            index_map.put(enroll[i], i);
            result_map.put(enroll[i], 0);
        }
        System.out.println(index_map);
        System.out.println(result_map);
    }

    //수익계산
    public static void calc(String sell, int a) {
        int total = a * 100;
        int tax;
        while(true) {
            tax = total/10;
            System.out.println(sell + " tax : " + tax + ", total : " +total);
            result_map.put(sell, result_map.get(sell) + (total-tax));
            System.out.println(result_map);
            sell = referral[index_map.get(sell)];
            if(sell.equals("-")) break;
            total = tax;
            if(total==0) break;
        }
    }

    //리스트출력
    public static int[] getList() {
        int[] arr = new int[enroll.length];
        for(int i=0 ; i<enroll.length ; i++) {
            arr[i] = result_map.get(enroll[i]);
        }
        return arr;
    }


    public static void printArray(int[] arr) {
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
