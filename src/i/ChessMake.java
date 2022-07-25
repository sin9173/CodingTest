package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChessMake {

    public static int width = 0;
    public static int height = 0;

    public static int min = 9999;

    public static ArrayList<String> check_list = new ArrayList<String>();
    public static ArrayList<String> lines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split1 = bf.readLine().replaceAll(" ", "~").split("~");
        height = Integer.parseInt(split1[0]);
        width  = Integer.parseInt(split1[1]);

        for(int i=0 ; i<height ; i++ ) {
            lines.add(bf.readLine());
        }
        convert(0);

        for(int i=0 ; i<check_list.size() ; i++ ) {
            String[] split = check_list.get(i).split("~");
            int result = 0;

            String a = split[0].substring(0, 1);
            String b = a.equals("B")?"W":"B";

            for(String s : split) {
                System.out.println("a : " + a + ", b : " + b + ", s : " + s);
                result += check(s, a, b);
                a = a.equals("B")?"W":"B";
                b = a.equals("B")?"W":"B";
            }

            if(result<min) min = result;

            result = 0;

            a = split[0].substring(0, 1).equals("B")?"W":"B";
            b = a.equals("B")?"W":"B";

            for(String s : split) {
                System.out.println("a : " + a + ", b : " + b + ", s : " + s);
                result += check(s, a, b);
                a = a.equals("B")?"W":"B";
                b = a.equals("B")?"W":"B";
            }

            if(result<min) min = result;

            System.out.println("result : " + result);
            System.out.println("==============================================");
        }

        System.out.println(min);
    }



    public static void convert(int width_point) {
        if(width_point==(width - 7)) return;

        for(int i=0 ; i<=height-8 ; i++) {
            StringBuilder rail = new StringBuilder();
            for(int j=i ; j<i+8 ; j++) {
                System.out.println("width : " + width);
                System.out.println("width point : " + width_point);
                String line = lines.get(j).substring(width_point, width_point + 8);
                System.out.println("line : " + line);
                rail.append(line + "~");
            }
            check_list.add(rail.toString());
        }
        System.out.println(check_list);
        convert((width_point + 1));
    }

    public static int check(String line, String a, String b) {
        int result = 0;

        for(int i=0 ; i<line.length()-1 ; i+=2) {
            String fr = line.substring(i, i+1);
            String rr = line.substring(i+1, i+2);
            if(!fr.equals(a)) result++;
            if(!rr.equals(b)) result++;
//            System.out.println("fr : " + fr + ", rr : " + rr + ", result : " + result);
        }
        return result;
    }
}
