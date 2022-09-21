package p1;

public class DigitSum {

    public static void main(String[] args) {
        String s = "123456789";
        System.out.println(hap(getDigitArr(s)));
    }

    public static int hap(int[] arr) {
        int hap = 0;
        for(int i = 0 ; i<arr.length ; i++) {
            hap += arr[i];
        }
        return hap;
    }

    public static int[] getDigitArr(String s) {
        int[] arr = new int[s.length()];
        String[] split = s.split("");
        for(int i=0 ; i<s.length() ; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}
