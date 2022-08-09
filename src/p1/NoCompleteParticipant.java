package p1;

import java.util.Arrays;

public class NoCompleteParticipant {

    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};


        System.out.println(search(0, completion, participant));

    }

    public static String search(int index, String[] comp, String[] part) {
        int flag = 0;
        String p = "";
        if(index==comp.length) {
            for(int i=0 ; i<part.length ; i++) if(!part[i].equals("")) p = part[i];
            return p;
        }
        for(int i=0 ; i<part.length ; i++) {
            if(part[i].equals("")) continue;
            p = part[i];

            System.out.println(p + " : " + comp[index]);
            if(p.equals(comp[index])) {
                part[i] = "";
                flag = 1;
                break;
            }
        }
        Arrays.stream(part).forEach(v -> System.out.print(v + ", "));
        System.out.println();
        if(flag==0) return p;
        return search(index+1, comp, part);
    }
}
