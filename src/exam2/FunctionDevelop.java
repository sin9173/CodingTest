package exam2;

import java.util.ArrayList;

public class FunctionDevelop {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        process(progresses, speeds);
    }

    public static int[] process(int[] progresses, int[] speeds) {
        int point = 0;
        int resultPoint = 0;
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        while(true) {
            for(int i=0 ; i<progresses.length ; i++) {
                if(progresses[i]<100) progresses[i]+=speeds[i];
                printArray(progresses);
            }
            if(progresses[point]>=100) {
                while(progresses[point]>=100) {
                    if(resultList.size()<=resultPoint) resultList.add(1);
                    else resultList.set(resultPoint, resultList.get(resultPoint)+1);
                    System.out.println("point : " + point + ", result : " + resultList);
                    point++;
                    if(point==progresses.length) break;
                }
                resultPoint++;
            }
            if(point==progresses.length) break;
        }

        int[] result = new int[resultList.size()];
        for(int i=0 ; i<resultList.size() ; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
