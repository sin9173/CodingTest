package g;

import java.io.*;
import java.util.ArrayList;

public class SugarDelivery {

    public static int weight = 0;

    public static int result = 0;

    public static int current = 0;

    public static ArrayList<Integer> array = new ArrayList<Integer>();

    public static int point = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        weight = Integer.parseInt(bf.readLine());
        if(weight%5==0) {
            System.out.println(weight/5);
            return;
        }

        while(true) {
            if(current>weight) break;
            array.add(5);
            current += 5;
            point++;
        }

        array = calc(array, weight);

        System.out.println(array);
        System.out.println("current : " + current);

        if(weight==current) System.out.println(array.size());
        else System.out.println(-1);

    }

    public static ArrayList<Integer> calc(ArrayList<Integer> array, int weight) {
        if (current==weight || array.get(0)==3 ) return array;
        array.set(point, 3);
        current -= 2;
        point--;
        if((weight-current)>=3) {
            array.add(3);
            current += 3;
        }
        return calc(array, weight);
    }
}
