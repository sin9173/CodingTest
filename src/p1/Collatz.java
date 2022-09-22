package p1;

public class Collatz {

    public static void main(String[] args) {
        int num = 626331;
        System.out.println(collatz(num));
    }

    public static int collatz(long num) {
        int count = 0;
        while(count<500 && num!=1) {
            if(num%2==0) num = num/2;
            else num = (num * 3) + 1;
            System.out.println("num : " + num);
            count++;
        }
        if(count==500 && num!=1) return -1;
        else return count;
    }
}
