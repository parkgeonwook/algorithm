package programmers.kit.heap.더_맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add(s);
        }

        int count = 0;
        while(pq.peek() < K) {
            if(pq.size() < 2) {
                count = -1;
                break;
            }

            int first = pq.poll();
            int second = pq.poll();
            int create = first + (2 * second);
            pq.add(create);
            count++;
        }

        return count;
    }
}
