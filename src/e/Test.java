package e;

public class Test {

    public static void main(String[] args) {
        String a = "국민Check카드 / OK: 00000000";
        String b = "1234567890123456";

        System.out.println(a.substring(0, a.indexOf("/")).trim());

        System.out.println(b.substring(0, 4) + "-" + b.substring(4, 8) + "-" + b.substring(8, 12) + "-" + b.substring(12));
    }
}
