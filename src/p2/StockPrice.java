package p2;

public class StockPrice {

    public static int[] arr;

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        arr = new int[prices.length];

        for(int i=0 ; i<prices.length ; i++) {
            arr[i] = search(prices, i, i+1, 0);
            printArray(arr);
        }

    }

    public static int search(int[] prices, int i, int j, int sec) {
        if(j==(prices.length)) return sec;
        sec++;
        if(prices[i]>prices[j]) return sec;

        System.out.println("i : " + i + ", j : " + j);
        return search(prices, i, j+1, sec);
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
