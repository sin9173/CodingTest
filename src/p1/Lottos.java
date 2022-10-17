package p1;

import java.util.Collections;
import java.util.HashSet;

public class Lottos {

    public static HashSet<Integer> win_set = new HashSet<Integer>();

    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        int[] result = solution(lottos, win_nums);
        for(int i=0 ; i<result.length ; i++) System.out.print(result[i] + ", ");
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        int num = 0;
        for(int i=0 ; i<win_nums.length ; i++) win_set.add(win_nums[i]);
        for(int i=0 ; i<lottos.length ; i++) {
            num = lottos[i];
            if(num==0) {
                answer[0] -= 1;
                continue;
            }
            if(win_set.contains(num)) {
                answer[0] -= 1;
                answer[1] -= 1;
            }
        }
        if(answer[0]==7) answer[0] = 6;
        if(answer[1]==7) answer[1] = 6;
        return answer;
    }
}
