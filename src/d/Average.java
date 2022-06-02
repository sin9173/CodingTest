package d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Average {

    public static double count = 0;

    public static String[] split = {};

    public static double max = 0;

    public static double sum = 0;

    public static double jum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        split = bf.readLine().replaceAll(" ", "~").split("~");

        for(int i=0 ; i<split.length ; i++) {
            jum = Integer.parseInt(split[i]);
            sum += jum;
            if(jum>max) max = jum;
        }

        System.out.println((sum * 100) / (max * count));

    }
}
