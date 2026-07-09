package programmers.kit.dfs_bfs.아이템_줍기;

import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];

        // **2배
        for(int[] r : rectangle) {
            for(int i = 0; i<4; i++) {
                r[i] *= 2;
            }
        }

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for(int[] r : rectangle) {
            int lx = r[0];
            int ly = r[1];
            int rx = r[2];
            int ry = r[3];

            for(int i = lx; i <= rx; i++) {
                for(int j = ly; j <= ry; j++) {
                    if(i == lx || i == rx || j == ly || j == ry) {
                        if(board[i][j] != 2) {
                            board[i][j] = 1;
                        }
                    } else {
                        board[i][j] = 2;
                    }
                }
            }
        }

        boolean[][] visited = new boolean[102][102];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Dot> queue = new ArrayDeque<>();
        queue.offer(new Dot(characterX, characterY, 0));
        visited[characterX][characterY] = true;

        while(!queue.isEmpty()) {
            Dot now = queue.poll();
            if(now.x == itemX && now.y == itemY){
                return now.dist / 2;
            }

            for(int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if(!visited[x][y] && board[x][y] == 1) {
                    queue.add(new Dot(x, y, now.dist+1));
                    visited[x][y] = true;
                }
            }
        }

        return -1;
    }

    class Dot {
        int x;
        int y;
        int dist;

        public Dot(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
