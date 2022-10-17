package exam2;

public class Hash {

    public static void main(String[] args) {
        String a = new String("aaa");
        String b = "bbb";

        int[] c = new int[1];

        System.out.println("a : " + a.hashCode());
        System.out.println("a : " + a);

        System.out.println("b : " + b.hashCode());
        System.out.println("b : " + b);

        System.out.println("c : " + c.hashCode());
        System.out.println("c : " + c);

    }
}
