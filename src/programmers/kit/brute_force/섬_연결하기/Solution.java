package programmers.kit.brute_force.섬_연결하기;

import java.util.*;

class Solution {
    int[] parent;

    public int solution(int n, int[][] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int[] cost : costs) {
            int v1 = cost[0];
            int v2 = cost[1];
            int c = cost[2];
            pq.offer(new Edge(v1, v2, c));
        }

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;
        int edgeCount = 0;
        while(!pq.isEmpty() && edgeCount < n-1) {
            Edge e = pq.poll();

            if(find(e.v1) != find(e.v2)) {
                union(e.v1, e.v2);
                edgeCount++;
                result += e.c;
            }
        }

        return result;
    }

    private int find(int n) {
        if(parent[n] == n) {
            return n;
        }

        return find(parent[n]);
    }

    private void union(int a, int b) {
        //parent[a] = find(b); <- 팀원만 팀 이동 되는 것과 같음.

        parent[find(a)] = find(b); // 팀장을 다른 곳에 붙여서 전체를 옮기는 것과 같음.
    }

    class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        public int compareTo(Edge e) {
            return this.c - e.c;
        }
    }
}