package programmers.kit.dp.등굣길;

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        int[][] map = new int[n+1][m+1];
        map[1][1] = 1;

        int size = puddles.length;
        for(int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            map[y][x] = -1;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {
                if(i == 1 && j == 1)
                    continue;

                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }

                map[i][j] = (map[i][j-1] + map[i-1][j]) % MOD;
            }
        }

        return map[n][m];
    }
}