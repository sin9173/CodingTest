package p2;

public class Test {

    public static void main(String[] args) {

        String a = "1.00";
        String b = "0.9";

        double ad = Double.parseDouble(a);
        double bd = Double.parseDouble(b.replaceAll("\\.", ""));

        System.out.println("a : " + ad + ", b : " + bd);
    }
}
