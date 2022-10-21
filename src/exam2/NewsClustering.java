package exam2;

import java.util.ArrayList;
import java.util.HashSet;

public class NewsClustering {

    public static HashSet<Integer> set = new HashSet<Integer>();

    public static ArrayList<String> union = new ArrayList<>();
    public static ArrayList<String> inter = new ArrayList<>();

    public static void main(String[] args) {
        String str1 = new String("handshake");
        String str2 = new String("shake hands");

        uni(str1, str2);

        System.out.println("union : " + union);
        System.out.println("inter : " + inter);
//
//
        System.out.println("result : " + calc());


    }

    public static int calc() {
        double union_size = union.size();
        double inter_size = inter.size();

        System.out.println("union : " + union_size + ", inter : " + inter_size);

        double zak = inter_size/union_size;

        System.out.println("zak : " + zak);

        if(union_size==0 && inter_size==0) return 65536;

        return (int)(zak * 65536);
    }


    public static void uni(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        String temp;

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        String[] split1 = str1.split("");
        String[] split2 = str2.split("");

        for(int i=1 ; i<split1.length ; i++) {
            temp = split1[i-1] + split1[i];
            if(!check(temp)) continue;
            list1.add(temp);
        }

        for(int i=1 ; i<split2.length ; i++) {
            temp = split2[i-1] + split2[i];
            if(!check(temp)) continue;
            list2.add(temp);
        }

        System.out.println("list1 : " + list1);
        System.out.println("list2 : " + list2);

        for(int i=0 ; i<list1.size() ; i++) {
            temp = list1.get(i);
            union.add(temp);
            for(int j=0 ; j<list2.size() ; j++) {

                System.out.println("temp : " + temp + " , > " + list2.get(j));
                if(temp.equals(list2.get(j))) {
                    inter.add(temp);
                    set.add(j);
                    break;
                }
            }
        }

        for(int i=0 ; i<list2.size() ; i++) {
            if(set.contains(i)) continue;
            union.add(list2.get(i));
        }
    }

    public static boolean check(String s) {
        char c;
        for(int i=0 ; i<s.length() ; i++) {
            c = s.charAt(i);
            if(!(c>=65 && c<=90) && !(c>=97 && c<=122)) return false;
        }
        return true;
    }
}
