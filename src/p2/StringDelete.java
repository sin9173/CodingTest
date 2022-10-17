package p2;

public class StringDelete {

    public static String[] alp = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};

    public static void main(String[] args) {
        String s = "baabaa";
        String temp = "";

        while(!s.equals("")) {
            temp = del(s);
            System.out.println("s : " + s + ", temp : " + temp);
            if(temp.equals(s)) break;
            s = temp;
            System.out.println(s);

        }
    }

    public static String del(String s) {
        String temp = s;
//        for(int i=0 ; i<(s.length()-1) ; i++) {
//            System.out.println(s.length());
//            System.out.println("i : " + i);
//            if(s.substring(i, i+1).equals("~")) continue;
//            if(s.substring(i, i+1).equals(s.substring(i+1, i+2))) {
//                temp = s.replaceAll((s.substring(i, i+1) + s.substring(i+1, i+2)), "~~");
//                System.out.println(temp);
//                break;
//            }
//        }

        for(int i=0 ; i<alp.length ; i++) {
            s = s.replaceAll(alp[i], "");
        }
        return s;
    }
}
