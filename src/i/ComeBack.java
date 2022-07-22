package i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComeBack {

    public static int num = 0;

    public static String under = "____";
    public static String require = "\"재귀함수가 뭔가요?\" \n";
    public static String response1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어. \n";
    public static String response2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지. \n";
    public static String response3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\" \n";
    public static String last_response = "\"재귀함수는 자기 자신을 호출하는 함수라네\" \n";
    public static String message = "라고 답변하였지. \n";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(bf.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다. \n" + bot(num + 1));
    }

    public static String bot(int n) {
        n--;
        String result = getUnder(num-n) + require;
        if(n==0) return result + getUnder(num - n) + last_response + getUnder(num - n) + message;
        else return result + getResponse(num - n) + bot(n) + getUnder(num - n) + message;
    }

    public static String getUnder(int n) {
        String result = "";
        for(int i=1 ; i<=n ; i++) result += under;
        return result;
    }

    public static String getResponse(int n) {
        String result = "";
        result += getUnder(n) + response1;
        result += getUnder(n) + response2;
        result += getUnder(n) + response3;
        return result;
    }
}
