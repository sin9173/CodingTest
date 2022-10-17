package p2;

public class Bracket {

    public static int point = 0;
    public static int[] arr = new int[100000];

    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(check(s));
    }

    public static boolean check(String s) {
        String c = "";
        for(int i=0 ; i<s.length() ; i++) {
            c = s.substring(i, i+1);
            if(c.equals("(")) insert(1);
            if(c.equals(")")) {
                if(point==0) return false;
                else get();
            }
        }

        if(point==0) return true;
        else return false;

    }

    public static void insert(int a) {
        arr[point++] = a;
    }

    public static int get() {
        return arr[--point];
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
