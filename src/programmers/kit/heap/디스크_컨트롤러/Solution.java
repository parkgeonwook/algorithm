package programmers.kit.heap.디스크_컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int time = 0;
        int index = 0;
        int totalTurnaround = 0;
        int count = 0;

        while(count < n) {

            while(index < n && jobs[index][0] <= time) {
                pq.add(jobs[index++]);
            }

            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                totalTurnaround += (time - job[0]);
                count++;
            } else {
                time = jobs[index][0];
            }
        }

        return totalTurnaround / n;
    }
}