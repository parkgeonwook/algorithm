package programmers.kit.brute_force.피로도;

// 지역 변수 내에서 k값 수정 후 복구. (호출 매개변수에 계산식 작성하면 됨)
class Solution {
    int max = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return max;
    }

    void dfs(int k, int count, int[][] dungeons) {
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons);

                visited[i] = false;
            }
        }
    }
}
