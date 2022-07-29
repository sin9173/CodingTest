package p1;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdNew {

    public static String regex = "^[a-z0-9]+([._a-z0-9-]+)+[a-z0-9]$";

    public static String word_regex = "^[a-z0-9]$";

    public static void main(String[] args) {
//        String new_id = ".baT#*..y.abcdefghijklm.";
        String new_id = ".ba.";
        System.out.println(pattern_check(new_id.substring(0, 1)));
        System.out.println(convert(new_id));
    }

    public static String solution(String new_id) {
        String answer = new_id;
        if(pattern_check(answer)) return answer;

        return answer;
    }

    public static boolean pattern_check(String s) {
        Pattern p = s.length()==1?Pattern.compile(word_regex):Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static String convert(String s) {
        if(s.equals("")) return "a";
        s = s.toLowerCase();
        if(s.substring(0, 1).equals(".")) s = s.substring(1);
        if(s.substring(s.length()-1).equals(".")) s = s.substring(0, s.length()-1);
        for(int i=0 ; i<s.length() ; i++) {
            String word = s.substring(i, i+1);
            if(word.equals(".")) continue;
            if(!pattern_check(word)) s = s.substring(0, i) + "&" + s.substring(i+1);
            System.out.println("word : " + word + ", s : " + s);
        }
        s = s.replaceAll("&", "");

        if(s.length()>15) s = s.substring(0, 15);
        if(s.substring(s.length()-1).equals(".")) s = s.substring(0, s.length()-1);

        System.out.println(" s : " + s);

        if(s.length()<3) {
            String word = s.substring(s.length()-1);
            for(int i=3 ; i>=s.length() ; i--) {
                s += word;
            }
        }

        return s;
    }
}
