package g;

import java.io.*;
import java.util.ArrayList;

public class Bansang {

    private static int count = 0;

    private static ArrayList<Case> list = new ArrayList<Case>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        count = Integer.parseInt(bf.readLine());

        for(int i=1 ; i<=count ; i++) list.add(new Case(Integer.parseInt(bf.readLine()), Integer.parseInt(bf.readLine())));

        for(Case c : list) {
            System.out.println("floor : " + c.floor + ", ho : " +c.ho);
            if(c.ho==1) {
                bw.write("1\n");
                continue;
            }
            int[] array = new int[c.ho];
            for(int i=0 ; i<array.length ; i++) array[i] = i+1;
            int result = calc(array, 1, c.floor);
            bw.write( + result + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int calc(int[] array, int floor, int max_floor) {
        if(floor>max_floor) return array[array.length-1];
        for(int i=1 ; i<array.length ; i++) array[i] = array[i] + array[i-1];
        System.out.print("[");
        for(int i=0 ; i<array.length ; i++) System.out.print(array[i] + ", ");
        System.out.println("]");
        return calc(array, floor+1, max_floor);
    }
}

class Case {
    int floor;
    int ho;

    Case(int floor, int ho) {
        this.floor = floor;
        this.ho = ho;
    }
}
