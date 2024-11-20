package p2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ParkingPayment {

    public static HashMap<Integer, Integer> timeMap = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Integer> parkingMap = new HashMap<Integer, Integer>();

    public static PriorityQueue<Parking> queue = new PriorityQueue<>((o1, o2) -> o1.car_num.compareTo(o2.car_num));

    public static void main(String[] args) {
        //int[] fees = {180, 5000, 10, 600};
        //String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        //int[] fees = {120, 0, 60, 591};
        //String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};

        mapping(records);

        bill_calc(fees);

        printArray(toArray());
    }

    public static int[] toArray() {
        int[] array = new int[queue.size()];
        for(int i=0 ; i<array.length ; i++) {
            Parking p = queue.poll();
            array[i] = p.bill;
        }
        return array;
    }

    public static void bill_calc(int[] fees) {
        int base_bill_minute = fees[0];
        int base_bill_amount = fees[1];
        int minute_rule = fees[2];
        int minute_amount = fees[3];

        Iterator<Integer> iterator = timeMap.keySet().iterator();

        Integer minute;
        int bill;
        int nam;
        int val;
        while(iterator.hasNext()) {
            Integer key = iterator.next();
            minute = timeMap.get(key);
            bill = base_bill_amount;
            nam = (minute - base_bill_minute) % minute_rule;
            val = (minute - base_bill_minute) / minute_rule;

            if(minute>base_bill_minute) {
                bill += (val * minute_amount);
                if(nam!=0) bill += minute_amount;
            }

            queue.offer(new Parking(key, bill));
        }

        System.out.println(queue);
    }

    public static void mapping(String[] records) {
        int minute;
        int car_num;

        Integer temp_time;

        for(int i=0 ; i<records.length ; i++) {
            String[] split = records[i].replaceAll(":", " ").split(" ");
            minute = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            car_num = Integer.parseInt(split[2]);

            System.out.println("car_num : " + car_num + ", minute : " + minute + ", " + split[3]);

            if(split[3].equals("IN")) {
                parkingMap.put(car_num, minute);
            } else {
                temp_time = timeMap.get(car_num);
                if(temp_time==null) temp_time = 0;
                timeMap.put(car_num, temp_time + (minute - parkingMap.get(car_num)));
                parkingMap.remove(car_num);
            }
        }

        System.out.println(timeMap);

        Iterator<Integer> iterator = parkingMap.keySet().iterator();
        minute = (23 * 60) + (59);
        while(iterator.hasNext()) {
            Integer key = iterator.next();
            temp_time = timeMap.get(key);
            if(temp_time==null) temp_time = 0;
            timeMap.put(key, temp_time + (minute - parkingMap.get(key)));
            parkingMap.remove(key);
        }

        System.out.println(timeMap);
        System.out.println(parkingMap);
    }

    //배열출력
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0 ; i<arr.length ; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("]");
    }
}


class Parking {
    public Integer car_num;
    public Integer bill;

    public Parking(Integer car_num, Integer bill) {
        this.car_num = car_num;
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "car_num=" + car_num +
                ", bill=" + bill +
                '}';
    }
}