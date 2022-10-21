package exam2;

public class BritCycle {
    public static void main(String[] args) {
        String s = "[][][[]][[[]]]";
        StringBuilder sb = new StringBuilder(s);

        int count = 0;

        for(int i=0 ; i<s.length() ; i++) {
            if(check(sb.toString())) count++;
            sb.append(sb.substring(0, 1));
            sb = sb.delete(0, 1);
        }

        System.out.println("count : " + count);
    }

    public static boolean check(String s) {

        String temp = "";

        while(true) {
            temp = s;
            s = s.replaceAll("\\[]", "");
            s = s.replaceAll("\\(\\)", "");
            s = s.replaceAll("\\{}", "");
            System.out.println("s : " + s);
            if(s.equals(temp)) break;
        }

        return s.equals("")?true:false;
    }
}
