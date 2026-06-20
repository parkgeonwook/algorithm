package programmers.kit.brute_force.소수_찾기;

import java.util.*;

// 문자열 다음에 넘길때 뭘 넘기는지 주의.
class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    char[] number;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        number = numbers.toCharArray();

        dfs(0, "", numbers);

        return set.size();
    }

    void dfs(int level, String s, String numbers) {

        if(level == numbers.length())
            return;

        for(int i = 0; i<numbers.length(); i++) {

            if(!visited[i]) {
                visited[i] = true;
                String next = s + number[i];
                int n = Integer.parseInt(next);

                if(isPrime(n))
                    set.add(n);

                dfs(level+1, next, numbers);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        if(n < 2)
            return false;

        for(int i = 2; i <= n / i; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}
