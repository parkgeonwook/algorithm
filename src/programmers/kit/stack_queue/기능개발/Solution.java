package programmers.kit.stack_queue.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] days = new int[len];
        for(int i = 0; i<len; i++) {
            days[i] = ((100 - progresses[i]) + speeds[i] - 1) / speeds[i];
        }

        int first = 0;
        List<Integer> answerList = new ArrayList<>();
        while(first < len) {
            int max = days[first];
            int i = first + 1;
            int count = 1;

            for( ; i < len; i++) {
                if(days[i] > max) {
                    break;
                }

                count++;
            }

            answerList.add(count);
            first = i;
        }

        int answerSize = answerList.size();
        int[] answer = new int[answerSize];

        for(int i = 0; i<answerSize; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
