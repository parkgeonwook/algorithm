package programmers.kit.dp.정수_삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] answer = new int[n][n];
        answer[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j<= i; j++) {
                if(j == 0) {
                    answer[i][0] = answer[i-1][0] + triangle[i][0];
                } else if(j == i) {
                    answer[i][j] = answer[i-1][j-1] + triangle[i][j];
                } else {
                    answer[i][j] = Math.max( answer[i-1][j-1],  answer[i-1][j]) + triangle[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int k : answer[n-1]) {
            max = Math.max(max, k);
        }

        return max;
    }
}
