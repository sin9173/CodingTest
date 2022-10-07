package p2;

import java.util.HashSet;

public class ChainGame {

    public static HashSet<String> set = new HashSet<String>();

    public static void main(String[] args) {
        String[] words = {"qwe", "eqwe", "eqwe"};
        int n = 2;

        printArray(chain(words, n));
    }

    public static int[] chain(String[] words, int n) {
        int turn = 0;
        int[] result = {0, 0};
        String r = "";
        String temp = "";
        int end = words.length;

        for(int i=0 ; i<words.length ; i++) {
            if(words[i].length()>1) {
                r = words[i].substring(0, 1);
                break;
            }
        }
        for(int i=0 ; i<words.length ; i++) {
            if(words[i].length()==1) end--;
        }

        while(true) {
            for(int i=1 ; i<=n ; i++) {
                turn++;
                for(int j=0 ; j<words.length ; j++) {
                    temp = words[j];
                    System.out.println("turn : " + turn);
                    System.out.println("r : " + r + ", f : " + temp);
                    if(r.equals(temp.substring(0, 1)) && !set.contains(temp) && temp.length()>1) {
                        r = temp.substring(temp.length()-1);
                        set.add(temp);
                        System.out.println(set);
                        break;
                    }
                    if(j==(words.length-1)) {
                        result[0] = i;
                        result[1] = turn%n==0?(turn/n):((turn/n) + 1);
                        return result;
                    }
                }
                if(turn==end) break;
            }
            if(turn==end) break;
        }
        return result;
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}
