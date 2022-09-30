package p2;

public class MaxMin {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        int[] arr = getArray(s);
        printArray(arr);
        System.out.println(getMaxMin(arr));
    }

    public static String getMaxMin(int[] arr) {
        int max = -99999999;
        int min = 999999999;

        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i]>max) max = arr[i];
            if(arr[i]<min) min = arr[i];
        }

        return min + " " + max;
    }

    public static int[] getArray(String s) {
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for(int i=0 ; i<arr.length ; i++) arr[i] = Integer.parseInt(split[i]);
        return arr;
    }


    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
