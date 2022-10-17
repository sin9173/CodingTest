package k;

public class CountSort {

    public static int count = 0;

    public static void main(String[] args) {
        int[] array = {10, 4, 3, 9, 11, 56, 32, 21, 5};
        countSort(array);
    }

    public static void countSort(int[] array) {
        int[] index = new int[57];
        int temp = 0;
        for(int i=0 ; i<array.length ; i++) {
            temp = array[i];
            index[temp] += 1;
        }

        for(int i=0 ; i<index.length ; i++) {
            for(int j=1 ; j<=index[i] ; j++) {
                System.out.println(i);
            }
        }
    }
}
