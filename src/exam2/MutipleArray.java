package exam2;

public class MutipleArray {

    public static void main(String[] args) {
        int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = {{5,4,3}, {2,4,1}, {3,1,1}};

        mul(arr1, arr2);
    }

    public static int[][] mul(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        int temp = 0;

        for(int i=0 ; i<arr1.length ; i++) {
            for(int j=0 ; j<arr2[0].length ; j++) {
                for(int k=0 ; k<arr1[0].length ; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                result[i][j] = temp;
                temp = 0;
                printArray(result);
            }
        }
        return result;
    }

    //배열출력
    public static void printArray(int[][] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.println("{");
            for(int j=0 ; j<arr[i].length ; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("}");
        }
        System.out.println("]");
    }
}
