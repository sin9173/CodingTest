package f;

import java.io.*;

public class AlphabetFind {

    public static String s = "";

    public static int[] array = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        s = bf.readLine();
        for(int i=0 ; i<array.length ; i++) array[i] = -1;

        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(array[c-97]==-1) array[c-97] = i;
        }

        for(int i=0 ; i<array.length ; i++) {
            System.out.print(array[i]);
            if(i<array.length-1) System.out.print(" ");
        }
    }


}
