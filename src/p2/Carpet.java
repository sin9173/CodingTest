package p2;

public class Carpet {

    public static void main(String[] args) {
        int b = 24;
        int y = 24;

        printArray(check(b, y));

    }

    public static int[] check(int b, int y) {
        int line;
        int flore = 0;
        int border;

        int[] result = new int[2];

        while(true) {
            flore++;
            if(y%flore>0) continue;
            line = y/flore;
            border = ((line + 2) * 2) + (flore * 2);
            if(border==b) {
                result[0] = line + 2;
                result[1] = flore + 2;
                break;
            }
        }
        return result;
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}
