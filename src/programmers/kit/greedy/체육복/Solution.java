package programmers.kit.greedy.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] student = new int[n];
        Arrays.fill(student, 1);

        for(int i : lost) {
            student[i-1]--;
        }

        for(int i : reserve) {
            student[i-1]++;
        }

        for(int i = 0; i<n; i++) {
            if(student[i] == 0) {
                if(i-1>=0 && student[i-1] == 2) {
                    student[i-1]--;
                    student[i]++;
                } else if(i+1<n && student[i+1] == 2) {
                    student[i+1]--;
                    student[i]++;
                }
            }
        }

        int count = 0;
        for(int i : student) {
            if(i > 0)
                count++;
        }

        return count;
    }
}
