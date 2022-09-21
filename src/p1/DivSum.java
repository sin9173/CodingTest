package p1;

public class DivSum {

    public static void main(String[] args) {
        int num = 12;

        System.out.println(getDivSum(num));
    }

    public static int getDivSum(int num) {
        int temp = 1;
        int hap = 0;

        while(temp<=(num/2)) {
            if(num%temp==0) {
                hap += temp;
                System.out.println(temp);
            }
            temp++;
        }

        return hap + num;
    }
}
