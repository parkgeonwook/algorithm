package programmers.kit.brute_force.전력망을_둘로_나누기;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {

        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            tree.add(new ArrayList<>());
        }

        // 초기 하나로 연결된 트리 세팅
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int answer = Integer.MAX_VALUE;

        //끊어보기
        for(int[] wire : wires) {
            int cutA = wire[0];
            int cutB = wire[1];

            boolean[] visited = new boolean[n+1];

            // 끊고 나서 한쪽 전력망의 송전탑 개수
            // 한쪽만 세면 나머지는 전체에서 빼면 나옴
            // 1을 넣은 건 그냥, 아무쪽이나 개수 셈.
            int count = dfs(1, cutA, cutB, tree, visited);

            int otherCount = n - count;
            int diff = Math.abs(count - otherCount);

            answer = Math.min(answer, diff);
        }

        return answer;
    }

    int dfs(int current, int cutA, int cutB, List<List<Integer>> tree, boolean[] visited) {
        visited[current] = true;
        int count = 1;

        for(int next : tree.get(current)) {
            // 끊은 전선은 건너뜀
            if((current == cutA && next == cutB) || (current == cutB && next == cutA)) {
                continue;
            }

            if(!visited[next]) {
                count += dfs(next, cutA, cutB, tree, visited);
            }
        }
        return count;
    }
}