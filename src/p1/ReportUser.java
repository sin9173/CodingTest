package p1;

import java.util.HashMap;
import java.util.HashSet;

public class ReportUser {

    public static HashSet<String> report_set = new HashSet<String>();
    public static HashMap<String, String> report_map = new HashMap<String, String>();
    public static HashMap<String, Integer> count_map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        solution(id_list, report, k);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        init_map(id_list);
        for(int i=0 ; i<report.length ; i++) check(report[i]);
        for(int i=0 ; i<id_list.length ; i++) {
            String reporters = report_map.get(id_list[i]);
            System.out.println("id : " + id_list[i] + " , reporters : " + reporters + ", size : " + reporters.split("~").length);
            count_check(reporters, k);
        }
        for(int i=0 ; i<id_list.length ; i++) answer[i] = count_map.get(id_list[i]);
        for(int i=0 ; i<answer.length ; i++) System.out.print(answer[i] + ", ");
        return answer;
    }

    public static void init_map(String[] id_list) {
        for(int i=0 ; i<id_list.length ; i++ ) {
            report_map.put(id_list[i], "");
            count_map.put(id_list[i], 0);
        }
    }

    public static void count_check(String rs, int k) {
        if(rs.equals("")) return;
        String[] split = rs.split("~");
        if(split.length>=k) {
            for(int i=0 ; i<split.length ; i++) count_map.put(split[i], count_map.get(split[i]) + 1);
        }
    }

    public static void check(String rep) {
        if(report_set.contains(rep)) return;
        report_set.add(rep);
        String[] split = rep.replaceAll(" ", "~").split("~");
        String warn = split[1];
        report_map.put(warn, report_map.get(warn) + split[0] + "~");
    }


}
