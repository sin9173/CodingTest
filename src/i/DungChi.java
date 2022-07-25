package i;

import java.io.*;
import java.util.ArrayList;

public class DungChi {

    public static int count = 0;

    public static ArrayList<Body> list = new ArrayList<Body>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(bf.readLine());

        for(int i=0 ; i<count ; i++) {
            String[] split = bf.readLine().replaceAll(" ", "~").split("~");
            int weight = Integer.parseInt(split[0]);
            int height = Integer.parseInt(split[1]);
            list.add(new Body(height, weight, 1));
        }

        check();

        System.out.println(list);

        for(int i=0 ; i<count ; i++) {
            int grade = list.get(i).grade;
            System.out.print(grade);
            if(i!=(count-1)) System.out.print(" ");
        }
    }

    public static void check() {
        for(int i=0 ; i<count ; i++) {
            for(int j=0 ; j<count ; j++) {
                if(i==j) continue;
                Body body1 = list.get(i);
                Body body2 = list.get(j);
                if(body1.height<body2.height && body1.weight < body2.weight) list.get(i).grade++;
            }
        }
    }
}

class Body {
    public int height;
    public int weight;
    public int grade;

    public Body(int height, int weight, int grade) {
        this.height = height;
        this.weight = weight;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Body{" +
                "height=" + height +
                ", weight=" + weight +
                ", grade=" + grade +
                '}';
    }
}
