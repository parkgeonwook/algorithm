package programmers.kit.brute_force.모의고사;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // arr은 학생이 제출한 답안.
        int[][] arr = new int[3][answers.length];
        for(int i = 0; i<answers.length; i++) {
            arr[0][i] = one[i % 5];
        }
        for(int i = 0; i<answers.length; i++) {
            arr[1][i] = two[i % 8];
        }
        for(int i = 0; i<answers.length; i++) {
            arr[2][i] = three[i % 10];
        }

        int[] result = new int[3];
        for(int i = 0; i<3; i++) {
            int correct = 0;
            for(int j=0; j<answers.length; j++) {
                if(answers[j] == arr[i][j]) {
                    correct++;
                }
            }
            result[i] = correct;
        }

        int max = Math.max(result[0], result[1]);
        max = Math.max(max, result[2]);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<3; i++) {
            if(max == result[i])
                list.add(i+1);
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
