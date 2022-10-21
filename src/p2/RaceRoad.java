package p2;

import java.math.BigDecimal;
import java.util.LinkedList;

public class RaceRoad {

    public static int x = 0;
    public static int y = 0;

    public static LinkedList<Step> stack = new LinkedList<>();

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0}, {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1}, {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};
        //int[][] board = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
        System.out.println(race(board, 0));
        x = 0;
        y = 0;
        System.out.println(race(board, 1));
    }

    public static int race(int[][] b, int flag) {
        int p = 1;

        int price = 0;

        while(true) {
            if(flag==0 && ((x==(b.length-1) || (x==0 && y!=0)|| b[y][x + p]==1))) {
                if(y==(b.length-1) || b[y+1][x]==1) {
                    System.out.println("back - " + "x : " + x + ", y : " + y + " price : " + price);
                    b[y][x] = 1;
                    Step s = stack.get(stack.size()-1);
                    stack.removeLast();
                    x = s.bx;
                    y = s.by;
                    price-=100;
                    continue;
                }
                flag=1;
                price += 500;
                continue;
            } else if(flag==1 && (y==(b.length-1) || b[y+1][x]==1)){
                if(x==0) p = 1;
                else if(x==b.length-1) p = -1;
                else if(b[y][x+p]==1) p *= -1;
                flag=0;
                price += 500;
                continue;
            }

            BigDecimal a = new BigDecimal(0);

            a  = BigDecimal.valueOf(1);



            stack.add(new Step(x, y));


            if(flag==0) {
                x+=p;
            }
            else y++;

            price += 100;

            System.out.println("x : " + x + ", y : " + y + ", price : " + price);

            if(y==(b.length-1) && x==(b[0].length -1)) {
                break;
            }

        }

        return price;
    }

    static class Step {
        int bx = 0;
        int by = 0;

        public Step(int x, int y) {
            this.bx = x;
            this.by = y;
        }
    }

}
