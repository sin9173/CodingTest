package p1;

public class Babble {

    public static String[] words = {"aya", "ye", "ma", "woo"};
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        replaceWord(babbling);
        System.out.println(calc(babbling));
    }

    public static void replaceWord(String[] babbling) {
        for(int i=0 ; i<babbling.length ; i++) {
            for(int j=0 ; j<words.length ; j++) {
                babbling[i] = babbling[i].replaceAll(words[j], "-");
            }
            printArray(babbling);
        }
    }

    public static int calc(String[] babbling) {
        int count = 0;
        for(int i=0 ; i<babbling.length ; i++) {
            babbling[i] = babbling[i].replaceAll("-", "");
            if(babbling[i].equals("")) count++;
        }
        printArray(babbling);
        return count;


    }

    public static void printArray(String[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) System.out.print(arr[i] + ", ");
        System.out.println("]");
    }
}
