package programmers.kit.dfs_bfs.단어_변환;

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];

        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node p = q.poll();
            if(p.str.equals(target)) {
                return p.result;
            }

            for(int i = 0; i<words.length; i++) {
                if(!visited[i] && canConvert(p.str, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], p.result+1));
                }
            }
        }

        return 0;
    }

    boolean canConvert(String s, String b) {
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != b.charAt(i))
                count++;
        }

        return count == 1;
    }

    class Node {
        String str;
        int result;

        public Node (String str, int result) {
            this.str = str;
            this.result = result;
        }
    }
}
