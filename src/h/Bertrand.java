package h;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Bertrand {

    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int input = Integer.parseInt(bf.readLine());
            if(input==0) break;
            else list.add(input);
        }

        for(int a : list) {
            bw.write(get_elem_count(a, a*2) + "\n");
        }

        bw.flush();
        bw.close();
    }


    public static int get_elem_count(int a, int b) {
        if(a==1) return 1;
        int flag = 3;
        HashSet<Integer> elems = new HashSet<Integer>();
        for(int i=a+1 ; i<b ; i++) if(i%2!=0) elems.add(i);

        while(true) {
            for(int i=(flag*2) ; i<b ; i+=flag) elems.remove(i);
            if(flag>=(b/2)) break;
            flag+=2;
        }
        System.out.println(elems.toString());
        return elems.size();
    }
}
