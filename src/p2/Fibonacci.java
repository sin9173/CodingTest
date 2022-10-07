package p2;

import java.math.BigDecimal;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 100;

        System.out.println(fibo(n).remainder(new BigDecimal(1234567)).intValue());
    }

    public static BigDecimal fibo(int n) {
        BigDecimal f1 = new BigDecimal(0);
        BigDecimal f2 = new BigDecimal(1);

        int count = 0;
        BigDecimal temp = new BigDecimal(0);

        while(true) {
            System.out.println("f1 : " + f1 + ", f2 : " + f2);
            if(n==count) break;
            temp = f2;
            f2 = f1.add(f2);
            f1 = temp;
            count++;
        }

        return f1;
    }
}
