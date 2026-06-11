package programmers.kit.stack_queue.프로세스;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        int size = priorities.length;
        Process[] process = new Process[size];
        Deque<Process> queue = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < size; i++) {
            int priority = priorities[i];
            pq.offer(priority);

            process[i] = new Process(priority);
            queue.offer(process[i]);
        }

        int count = 0;
        while(true) {
            Process poll = queue.poll();
            int max = pq.poll();

            if(poll.priority == max) {
                count++;

                if(poll == process[location]) {
                    return count;
                }
            } else {
                queue.offer(poll);
                pq.offer(max);
            }
        }

    }

    class Process {
        int priority;

        public Process(int priority) {
            this.priority = priority;
        }
    }
}
