package programmers.kit.dfs_bfs.퍼즐_조각_채우기;

import java.util.*;

class Solution {

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        List<List<Point>> spaces = extractShape(game_board, 0);
        List<List<Point>> pieces = extractShape(table, 1);

        boolean[] used = new boolean[pieces.size()];

        int sum = 0;
        for(List<Point> space : spaces) {
            for(int i = 0; i<pieces.size(); i++) {
                if(used[i])
                    continue;

                List<Point> piece = pieces.get(i);

                if(space.size() != piece.size())
                    continue;

                if(canMatch(space, piece)) {
                    used[i] = true;
                    sum += piece.size();
                    break;
                }
            }
        }

        return sum;
    }


    private List<List<Point>> extractShape(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<Point>> shapes = new ArrayList<>();

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(!visited[r][c] && board[r][c] == target) {
                    List<Point> shape = bfs(board, visited, r, c, target);
                    shapes.add(normalize(shape));
                }
            }
        }

        return shapes;
    }

    private List<Point> normalize(List<Point> shape) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(Point s : shape) {
            minX = Math.min(minX, s.x);
            minY = Math.min(minY, s.y);
        }

        List<Point> nomalized = new ArrayList<>();

        for(Point s : shape) {
            s.x -= minX;
            s.y -= minY;
            nomalized.add(new Point(s.x, s.y));
        }

        Collections.sort(nomalized);

        return nomalized;
    }

    private List<Point> bfs(int[][] board, boolean[][] visited, int r, int c, int target) {
        int n = board.length;

        Queue<Point> queue = new ArrayDeque<>();
        List<Point> shape = new ArrayList<>();

        queue.offer(new Point(r,c));
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            shape.add(current);

            for(int i = 0; i<4; i++) {
                int x = current.x + dx[i];
                int y = current.y + dy[i];

                if(x < 0 || x >= n || y < 0 || y>=n)
                    continue;

                if(visited[x][y])
                    continue;

                if(board[x][y] != target)
                    continue;

                visited[x][y] = true;
                queue.offer(new Point(x, y));
            }
        }

        return shape;
    }

    private boolean canMatch(List<Point> space, List<Point> piece) {
        List<Point> rotated = normalize(piece);

        for(int i = 0; i<4; i++) {
            if(sameShape(space, rotated))
                return true;

            rotated = rotate(rotated);
        }

        return false;
    }

    private List<Point> rotate(List<Point> shape) {
        List<Point> rotated = new ArrayList<>();

        for(Point p : shape) {
            rotated.add(new Point(p.y, -p.x));
        }

        return normalize(rotated);
    }

    private boolean sameShape(List<Point> shape1, List<Point> shape2) {

        for(int i = 0; i<shape1.size(); i++){
            if(shape1.get(i).x != shape2.get(i).x || shape1.get(i).y != shape2.get(i).y)
                return false;
        }

        return true;
    }

    class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x)
                return Integer.compare(this.y, o.y);

            return Integer.compare(this.x, o.x);
        }
    }
}