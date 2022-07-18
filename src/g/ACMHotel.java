package g;

import java.io.*;
import java.util.ArrayList;

public class ACMHotel {

    public static int test_count = 0;
    public static ArrayList<Building> test_cases = new ArrayList<Building>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        test_count = Integer.parseInt(bf.readLine());

        for(int i=1 ; i<=test_count ; i++) {
            String[] split = bf.readLine().replaceAll(" ", "~").split("~");
            test_cases.add(new Building(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
        for(Building b : test_cases) {
            int temp1 = b.people / b.height;
            int temp2 = b.people % b.height;

            String front = String.valueOf(temp2==0?b.height:temp2);
            String rear = String.valueOf(temp2==0?temp1:temp1+1);
            if(rear.length()==1) rear = "0" + rear;

            bw.write(front + rear + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class Building {
    public int height = 0;

    public int room = 0;

    public int people = 0;

    Building(int height, int room, int people) {
        this.height = height;
        this.room = room;
        this.people = people;
    }
}
