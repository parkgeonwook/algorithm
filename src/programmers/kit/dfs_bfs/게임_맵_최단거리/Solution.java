package programmers.kit.dfs_bfs.게임_맵_최단거리;

import java.util.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        boolean[][] visited = new boolean[n+1][m+1];

        Deque<Dot> queue = new ArrayDeque<>();
        queue.offer(new Dot(0, 0));
        visited[0][0] = true;
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Dot poll = queue.poll();
                if(poll.x == n && poll.y == m)
                    return count;
                for(int j = 0; j<4; j++) {
                    int x = poll.x + dx[j];
                    int y = poll.y + dy[j];
                    if(x >= 0 && x <= n && y >= 0 && y <= m && maps[x][y] == 1 && !visited[x][y]) {
                        queue.offer(new Dot(x, y));
                        visited[x][y] = true;
                    }
                }
            }
            count++;
        }

        return -1;
    }

    class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
