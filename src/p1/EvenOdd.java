package p1;

public class EvenOdd {

    public static void main(String[] args) {
        int num = 3;
        System.out.println(oddEven(num));
    }

    public static String oddEven(int num) {
        if(num%2==0) return "Even"; else return "Odd";
    }
}
