package k;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutLine {

    public static Integer[] scores = {};
    public static int count = 0;
    public static int cut = 0;

    public static int[] count_array = {};

    public static void main(String[] args) throws IOException {
        initPro();
        countSort();
        System.out.println(cutScore());
    }

    public static void initPro() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().replaceAll(" ", "~").split("~");
        count = Integer.parseInt(split[0]);
        cut = Integer.parseInt(split[1]);
        scores = Arrays.stream(bf.readLine().replaceAll(" ", "~").split("~")).map(v -> Integer.parseInt(v)).toArray(Integer[]::new);

        count_array = new int[10001];
    }

    public static void countSort() {
        int point = 0;
        for(int i=0 ; i<count ; i++) count_array[scores[i]] += 1;
        for(int i=(count_array.length-1) ; i>=0 ; i--) {
            for(int j=1 ; j<=count_array[i] ; j++) {
                scores[point] = i;
                point++;
            }
        }
        System.out.print("[");
        for(int i=0 ; i<scores.length ; i++) {
            System.out.println(scores[i] + ", ");
        }
        System.out.println("]");
    }

    public static Integer cutScore() {
        return scores[cut-1];
    }
}
