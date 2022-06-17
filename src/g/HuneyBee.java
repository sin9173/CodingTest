package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HuneyBee {

    public static int num = 0;

    public static int room_num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        for(int i=1 ; true ; i++) {
            if(num<=room_num) {
                room_num = i;
                break;
            }
            room_num = room_num + (i * 6);
        }
        System.out.println(room_num);
    }
}
