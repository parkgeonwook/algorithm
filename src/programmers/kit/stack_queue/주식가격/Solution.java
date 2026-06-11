package programmers.kit.stack_queue.주식가격;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];

        Deque<Integer> aliveIndexStack = new ArrayDeque<>();
        aliveIndexStack.push(0);
        for (int i = 1; i < size; i++) {
            Integer top = aliveIndexStack.peek();
            if(prices[i] < prices[top]) {
                answer[top] = i - top;
                aliveIndexStack.pop();
            }
            aliveIndexStack.push(i);
        }

        while(!aliveIndexStack.isEmpty()) {
            Integer top = aliveIndexStack.peek();
            answer[top] = (size-1) - top;
            aliveIndexStack.pop();
        }

        return answer;
    }
}