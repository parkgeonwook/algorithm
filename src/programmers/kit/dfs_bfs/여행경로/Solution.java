package programmers.kit.dfs_bfs.여행경로;

import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    boolean[] visited;
    boolean found = false;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));

        list.add("ICN");
        dfs(0, "ICN", tickets);

        return list.toArray(new String[0]);
    }

    private void dfs(int count, String current, String[][] tickets) {
        if(count == tickets.length) {
            found = true;
            return;
        }

        for(int i = 0; i<tickets.length; i++) {
            if(!visited[i] && current.equals(tickets[i][0])) {
                visited[i] = true;
                list.add(tickets[i][1]);

                dfs(count+1, tickets[i][1], tickets);
                if(found) {
                    return;
                }
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}