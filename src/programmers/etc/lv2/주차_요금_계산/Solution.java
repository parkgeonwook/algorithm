package programmers.etc.lv2.주차_요금_계산;

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inTimeMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new HashMap<>();

        // records로부터 inTime과 totalTime 계산.
        for(String record : records) {
            String[] parts = record.split(" ");
            int time = timeToInt(parts[0]);
            String car = parts[1];
            String action = parts[2];

            if(action.equals("IN")) {
                inTimeMap.put(car, time);
            } else {
                int inTime = inTimeMap.get(car);
                int totalTime = time - inTime;
                totalTimeMap.put(car, totalTimeMap.getOrDefault(car, 0) + totalTime);
            }
        }

        // intTimeMap에 남아있는 입차 시간은 출차시간 23:59로 해서 계산
        int lastTime = timeToInt("23:59");
        for(String restCar : inTimeMap.keySet()) {
            int totalTime = lastTime - inTimeMap.get(restCar);
            totalTimeMap.put(restCar, totalTimeMap.getOrDefault(restCar, 0) + totalTime);
        }

        // totalTimeMap을 기준으로 총 요금 계산.
        // 요금 맵
        Map<String, Integer> feeMap = new HashMap<>();
        for(String car : totalTimeMap.keySet()) {
            int fee = calculateFee(totalTimeMap.get(car), fees);
            feeMap.put(car, fee);
        }

        //차량 번호순 정렬
        //Map을 바로 정렬 못함. 리스트로 차 이름만 정렬 후 맵이용해서 값을 결과에 저장
        List<String> cars = new ArrayList<>(feeMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        for(int i = 0; i<answer.length; i++) {
            answer[i] = feeMap.get(cars.get(i));
        }

        return answer;
    }

    private int timeToInt(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        return hour * 60 + min;
    }

    private int calculateFee(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if(totalTime <= baseTime)
            return baseFee;

        int overTime = totalTime - baseTime;
        return baseFee + ((overTime + unitTime - 1) / unitTime) * unitFee;
    }
}
