package programmers.kit.sort.K번째수;

import java.util.*;

// Arrays.copyOfRange() 사용
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;

        int[] answer = new int[size];

        for(int i = 0; i < size; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;

            int[] sliced = Arrays.copyOfRange(array, start, end);

            Arrays.sort(sliced);

            answer[i] = sliced[k];
        }

        return answer;
    }
}
