package programmers.kit.dfs_bfs.네트워크;

class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int network = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                network++;
            }
        }

        return network;
    }

    void dfs(int i, int n, int[][] computers) {
        visited[i] = true;

        for(int j = 0; j < n; j++) {
            if(!visited[j] && computers[i][j] == 1) {
                dfs(j, n, computers);
            }
        }
    }
}
