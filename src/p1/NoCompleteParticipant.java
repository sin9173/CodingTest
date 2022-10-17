package p1;

import java.util.Arrays;
import java.util.HashMap;

public class NoCompleteParticipant {

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};


//        System.out.println(search(0, completion, participant));
        System.out.println(search(completion, participant));

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

    public static String search(String[] comp, String[] part) {
        String result = "";
        HashMap<String, Integer> comp_map = new HashMap<>();
        HashMap<String, Integer> part_map = new HashMap<>();

        for(int i=0 ; i<comp.length ; i++) {
            comp_map.put(comp[i], comp_map.get(comp[i]) == null ? 0 : comp_map.get(comp[i]) + 1);
        }

        for(int i=0 ; i<part.length ; i++ ) {
            part_map.put(part[i], part_map.get(part[i]) == null ? 0 : part_map.get(part[i]) + 1);
        }

        for(int i=0 ; i<part.length ; i++) {
            int temp = part_map.get(part[i]);
            if(comp_map.get(part[i])==null || comp_map.get(part[i])!=temp) {
                result = part[i];
                break;
            }
        }
        return result;
    }

}
