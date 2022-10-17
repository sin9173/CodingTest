package p2;

public class BitConvert {

    public static void main(String[] args) {
        int[] a = cycle("110010101001");
        System.out.println("a : " + a[0]);
        System.out.println("b : " + a[1]);
    }

    public static int[] cycle(String s) {
        int count = 0;
        int remove_count = 0;
        String temp = "";
        int[] result = new int[2];

        while(!s.equals("1")) {
            temp = remove(s);
            count++;
            remove_count += (s.length() - temp.length());
            s = bit(temp.length());
            System.out.println(s);
        }

        result[0] = count;
        result[1] = remove_count;

        return result;
    }

    public static String bit(long a) {
        long n = 0;
        String result = "";
        while(a>0) {
            n = a%2;
            a = a/2;
            result = n + result;
        }
        return result;
    }

    public static String remove(String s) {
        return s.replaceAll("0", "");
    }
}
