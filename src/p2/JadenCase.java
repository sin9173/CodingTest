package p2;

public class JadenCase {

    public static void main(String[] args) {
        String s = "3people unFollowed  me";
        String[] arr = getArray(s);
        printArray(arr);
        System.out.println(jaden(arr));
    }

    public static String jaden(String[] arr) {
        String result = "";
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i].length()>0) result += arr[i].substring(0, 1).toUpperCase();
            if(arr[i].length()>1) result += arr[i].substring(1).toLowerCase();
            result += " ";
        }
        return result.substring(0, result.length()-1);
    }

    public static String[] getArray(String s) {
        return s.split(" ", -1);
    }

    //배열출력
    public static void printArray(String[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
