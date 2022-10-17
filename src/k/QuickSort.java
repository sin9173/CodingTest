package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuickSort {

    public static int count = 0;

    public static ArrayList<Integer> list = new ArrayList<>();

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<count ; i++) list.add(Integer.parseInt(bf.readLine()));

        quickSort(list, 0, list.size()-1);
        list.forEach(i -> sb.append(i + "\n"));
        System.out.println(sb.toString());
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> list, int originLeft, int originRight) {
        int left = originLeft;
        int right = originRight;
        int temp;

        int pivot = list.get((originLeft + originRight)/2);

        while(left<=right) {
            while(list.get(left)<pivot) left++; //left 가 pivot 보다 큰값이거나 pivot 을 만날 때까지 이동
            while(list.get(right)>pivot) right--; //right 가 pivot 보다 작은값이거나 pivot 을 만날 때까지 이동

            if(left<=right) {
                temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
                left++;
                right--;
                System.out.println(list);
            }
        }

        if(originLeft<right) list = quickSort(list, originLeft, right);
        if(originRight>left) list = quickSort(list, left, originRight);

        return list;
    }
}
