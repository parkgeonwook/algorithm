package programmers.kit.graph.가장_먼_노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] e : edge) {
            int v1 = e[0];
            int v2 = e[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int size = 0;

        while(!queue.isEmpty()) {
            size = queue.size();

            for(int i =0; i<size; i++) {
                int poll = queue.poll();
                for(int v : graph.get(poll)) {
                    if(!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
        }

        return size;
    }
}
