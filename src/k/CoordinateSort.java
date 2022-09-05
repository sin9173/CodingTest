package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CoordinateSort {

    public static Integer count = 0;

    public static Integer[][] input = {};

    public static void main(String[] args) throws IOException {
        init();
        printArray(input);
        input = quickSort(input, 0, input.length-1, 0);
        input = check(input);
        printArray(input);
    }

    public static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        input = new Integer[5][2];
        for(int i=0 ; i<input.length ; i++) {
            input[i] = Stream.of(bf.readLine().replaceAll(" ", "~").split("~"))
                    .map(s -> Integer.parseInt(s))
                    .toArray(Integer[]::new);
        }
    }

    public static Integer[][] quickSort(Integer[][] array, Integer originLeft, Integer originRight, int flag) {
        int left = originLeft;
        int right = originRight;
        int pivot = array[originLeft + ((originRight - originLeft)/2)][flag];

        Integer[] temp;

        while(left<=right) {
            while(array[left][flag]<pivot) left++;
            while(array[right][flag]>pivot) right--;

            if(left<=right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        if(originLeft<=right) array = quickSort(array, originLeft, right, flag);
        if(originRight>=left) array = quickSort(array, left, originRight, flag);

        return array;
    }

    public static Integer[][] check(Integer[][] array) {
        int left = 0;
        int right = 0;

        while(right<array.length) {
            while(array[left][0]==array[right+1][0] && right<array.length-1) right++;
            if(right>left) {
                array = quickSort(array, left, right, 1);
                left = right;
            }
            left++;
            right++;
        }
        return array;
    }

    public static void printArray(Integer[][] array) {
        System.out.println("{");
        for(int i=0 ; i<array.length ; i++) {
            System.out.print("[");
            for(int j=0 ; j<array[i].length ; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println("]");
        }
        System.out.println("}");
    }


}
