package p2;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatting {

    public static HashMap<String, String> nameMap = new HashMap<>();

    public static ArrayList<ChatLog> logList = new ArrayList<>();

    public static void main(String[] args) {
        String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        read(records);

        System.out.println(nameMap);
        System.out.println(logList);

        printArray(toArray());
    }

    public static String[] toArray() {
        String[] array = new String[logList.size()];
        for(int i=0 ; i<logList.size() ; i++) {
            ChatLog cl = logList.get(i);
            array[i] = nameMap.get(cl.user_id) + "님이 " + cl.message;
        }
        return array;
    }

    public static void read(String[] record) {
        String[] split;
        String message;
        for(int i=0 ; i<record.length ; i++) {
            split = record[i].split(" ");
            if(split[0].equals("Leave")) {
                message = "나갔습니다.";
            } else {
                nameMap.put(split[1], split[2]);
                message = "들어왔습니다.";
            }
            if(!split[0].equals("Change")) logList.add(new ChatLog(split[1], message));
        }
    }

    //배열출력
    public static void printArray(String[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}

class ChatLog {
    public String user_id;
    public String message;

    public ChatLog(String user_id, String message) {
        this.user_id = user_id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatLog{" +
                "user_id='" + user_id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
