package f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWord {

    public static int count = 0;
    public static int group_count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());
        for(int i=0 ; i<count ; i++) {
            group_count += group_check(bf.readLine());
        }
        System.out.println(group_count);
    }

    public static int group_check(String s) {
        while(s.length()!=1) {
            String fir = s.substring(0, 1);
            s = s.substring(1);
            if(!s.substring(0, 1).equals(fir)) {
                int size = s.length();
                s = s.replaceAll(fir, "");
                if(s.length()!=size) return 0;
            }
        }
        return 1;
    }
}
