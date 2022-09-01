package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SortInsight {

    public static Integer[] nums = {};

    public static void main(String[] args) throws IOException {
        init();
        printArray(nums);
        nums = quickSort(nums, 0, nums.length);
    }

    public static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        nums = Stream.of(bf.readLine().split("")).map(s -> Integer.parseInt(s)).toArray(Integer[]::new);
    }

    public static Integer[] quickSort(Integer[] array, Integer originLeft, Integer originRight) {
        int left = originLeft;
        int right = originRight;
        int pivot = array[originLeft + ((originRight-originLeft)/2)];

        int temp;

        while(left<=right) {
            while(left<=pivot) left++;
            while(right>=pivot) right--;

            if(left<=right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
                printArray(array);
            }

        }

        if(originLeft<right) array = quickSort(array, originLeft, right);
        if(originRight>left) array = quickSort(array, left, originRight);

        return array;
    }

    public static void printArray(Integer[] array) {
        System.out.print("[");
        for(int i=0 ; i<array.length ; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }
}
