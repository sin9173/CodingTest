package p3;

import java.util.HashSet;
import java.util.Iterator;

public class ArrayBorder {

    //이동값 저장
    public static HashSet<Integer> moveSet = new HashSet<Integer>();

    public static void main(String[] args) {
        int row = 5;
        int col = 6;
        int[][] a = null;
        int[] border = {2, 2, 5, 4};

        int[][] arr = initArray(row, col);
        printArray(arr);

        arr = cycle(arr, border);

        System.out.println("min : " + getMin());
    }

    //배열 회전
    public static int[][] cycle(int[][] arr, int[] border) {
        int start_width = border[1]-1;
        int end_width = border[3]-1;
        int start_height = border[0]-1;
        int end_height = border[2]-1;

        int width = start_width;
        int height = start_height;

        int flag = 1;

        int temp1 = 0;
        int temp2 = 0;

        while(true) {
            while(true) {
                System.out.println("width : " + width + ", height : " + height);

                if(temp1!=0) {
                    temp2 = arr[height][width];
                    arr[height][width] = temp1;
                    temp1 = temp2;
                } else {
                    temp1 = arr[height][width];
                }
                moveSet.add(temp1);

                if(flag==1 && width==end_width) {
                    height++;
                    break;
                }
                else if(flag==-1 && width==start_width) {
                    height--;
                    break;
                }
                else width+=flag;
            }
            System.out.println("END WIDTH ");
            while(true) {
                System.out.println("width : " + width + ", height : " + height);

                temp2 = arr[height][width];
                arr[height][width] = temp1;
                temp1 = temp2;
                moveSet.add(temp1);

                if(flag==1 && height==end_height) {
                    width--;
                    break;
                }
                else if(flag==-1 && height==start_height) break;
                else height += flag;
            }
            System.out.println("END HEIGHT");

            if(flag==-1) break;
            else flag = flag * -1;
        }

        System.out.println(moveSet);

        return arr;
    }

    //배열 초기화
    public static int[][] initArray(int r, int c) {
        int[][] arr = new int[r][c];
        int count = 0;

        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                count++;
                arr[i][j] = count;
            }
        }
        return arr;
    }
    
    //최소값 얻기
    public static int getMin() {
        int min = 9999999;

        Iterator<Integer> iterator = moveSet.iterator();

        while(iterator.hasNext()) {
            int a = iterator.next();
            if(a<min) min = a;
        }

        moveSet.clear();

        return min;
    }

    public static void printArray(int[][] arr) {
        for(int i=0 ; i<arr.length ; i++) {
            for(int j=0 ; j<arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
