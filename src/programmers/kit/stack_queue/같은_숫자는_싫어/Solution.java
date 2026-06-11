package programmers.kit.stack_queue.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            if(deque.peekLast() != arr[i])
                deque.offer(arr[i]);
        }

        int size = deque.size();
        int[] answer = new int[size];

        for(int i = 0; i<size; i++) {
            answer[i] = deque.pop();
        }

        return answer;
    }
}
